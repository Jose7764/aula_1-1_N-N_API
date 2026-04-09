package com.example.aula_test.mapper;

import org.springframework.stereotype.Component;

import com.example.aula_test.dto.funcionario.FuncionarioResponse;
import com.example.aula_test.dto.funcionario.FuncionarioResquest;
import com.example.aula_test.model.Funcionario;

@Component
public class FuncionarioMapper {
    
    public Funcionario toEntity(FuncionarioResquest dto){
        return new Funcionario(
            dto.nome()
        );
    }

    public FuncionarioResponse toResponse(Funcionario funcionario){
        return new FuncionarioResponse(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getAssento(),
            funcionario.getProjetos()
        );
    }
}
