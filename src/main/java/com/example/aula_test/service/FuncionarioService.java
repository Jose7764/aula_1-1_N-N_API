package com.example.aula_test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aula_test.dto.funcionario.FuncionarioResponse;
import com.example.aula_test.dto.funcionario.FuncionarioResquest;
import com.example.aula_test.mapper.FuncionarioMapper;
import com.example.aula_test.model.Assento;
import com.example.aula_test.model.Funcionario;
import com.example.aula_test.repository.AssentoRepository;
import com.example.aula_test.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final AssentoRepository assentoRepository;
    private final FuncionarioMapper mapper;
    
    public FuncionarioResponse create(FuncionarioResquest dto){
        
        Assento assento = assentoRepository.findById(dto.idAssento()).orElseThrow(()-> new RuntimeException("Assento não Existe!"));

        Funcionario funcionario = mapper.toEntity(dto);
        funcionario.setAssento(assento);

        return mapper.toResponse(repository.save(funcionario));
    }

    public List<FuncionarioResponse> listAll(){
        return repository.findAll().stream().map(mapper::toResponse).toList();
    } 

    public FuncionarioResponse listById(long id){
       return mapper.toResponse(repository.findById(id).orElseThrow(()-> new RuntimeException("Funcionario não Encontrado!")));
    }

    public FuncionarioResponse update (long id, FuncionarioResquest dto){
        Funcionario funcionario = repository.findById(id).orElseThrow(()-> new RuntimeException("Funcionario não Encontrado!"));
        Assento assento = assentoRepository.findById(dto.idAssento()).orElseThrow(()-> new RuntimeException("Assento não Existe!"));

        funcionario.setNome(dto.nome());
        funcionario.setAssento(assento);
        return mapper.toResponse(repository.save(funcionario));
    }

    public void delete (long id){
        repository.deleteById(id);
    }
}
