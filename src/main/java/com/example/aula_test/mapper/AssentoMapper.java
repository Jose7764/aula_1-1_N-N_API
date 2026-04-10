package com.example.aula_test.mapper;

import org.springframework.stereotype.Component;

import com.example.aula_test.dto.assento.AssentoRequest;
import com.example.aula_test.dto.assento.AssentoResponse;
import com.example.aula_test.model.Assento;

@Component
public class AssentoMapper {
    
    public Assento toEntity(AssentoRequest dto){
        return new Assento(
            dto.codigo()
        );
    }

    public AssentoResponse toResponse(Assento assento){
        return new AssentoResponse(
            assento.getId(),
            assento.getCodigo(),
            assento.getFuncionario().getNome()
        );
    }
}
