package com.example.aula_test.mapper;

import org.springframework.stereotype.Component;

import com.example.aula_test.dto.projeto.ProjetoRequest;
import com.example.aula_test.dto.projeto.ProjetoResponse;
import com.example.aula_test.model.Projeto;

@Component
public class ProjetoMapper {
    
    public Projeto toEntity (ProjetoRequest dto){
        return new Projeto(
            dto.nome()
        );
    }

    public ProjetoResponse toResponse(Projeto projeto){
        return new ProjetoResponse(
            projeto.getId(),
            projeto.getNome(),
            projeto.getFuncionarios()
        );
    }
}
