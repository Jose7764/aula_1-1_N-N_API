package com.example.aula_test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aula_test.dto.projeto.ProjetoRequest;
import com.example.aula_test.dto.projeto.ProjetoResponse;
import com.example.aula_test.mapper.ProjetoMapper;
import com.example.aula_test.model.Projeto;
import com.example.aula_test.repository.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService {
    
    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoResponse create(ProjetoRequest dto){
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<ProjetoResponse> listAll(){
        
        return repository.findAll()
                        .stream()
                        .map(mapper::toResponse)
                        .toList();
    }

    public ProjetoResponse listById(long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(()-> new RuntimeException("Projeto não encontrado!")));
    }

    public ProjetoResponse update(long id, ProjetoRequest dto){

        Projeto projeto = repository.findById(id).orElseThrow(()-> new RuntimeException("Projeto não encontrado!"));
        projeto.setNome(dto.nome());

        return mapper.toResponse(projeto);
    }

    public void delete(long id){
        repository.deleteById(id);
    }
}
