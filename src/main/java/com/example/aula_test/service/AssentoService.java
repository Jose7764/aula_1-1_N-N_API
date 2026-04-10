package com.example.aula_test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aula_test.dto.assento.AssentoRequest;
import com.example.aula_test.dto.assento.AssentoResponse;
import com.example.aula_test.mapper.AssentoMapper;
import com.example.aula_test.model.Assento;
import com.example.aula_test.model.Funcionario;
import com.example.aula_test.repository.AssentoRepository;
import com.example.aula_test.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRepository repository;
    private final AssentoMapper mapper;
    private final FuncionarioRepository funcionarioRepository;

    public AssentoResponse create(AssentoRequest dto){   
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<AssentoResponse> listAll(){
        return repository.findAll()
        .stream()
        .map(mapper::toResponse)
        .toList();
    }

    public AssentoResponse listById(long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(()-> new RuntimeException("Assento não encontrado!")));
    }

    public AssentoResponse update (long id , AssentoRequest dto){
        Assento assento = repository.findById(id).orElseThrow(()-> new RuntimeException("Assento não encontrado!"));
    
        assento.setCodigo(dto.codigo());

        return mapper.toResponse(repository.save(assento));
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
