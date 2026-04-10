package com.example.aula_test.mapper;

import org.springframework.stereotype.Component;

import com.example.aula_test.dto.assento.AssentoResponse;
import com.example.aula_test.dto.funcionario.FuncionarioResponse;
import com.example.aula_test.dto.funcionario.FuncionarioResponseAssento;
import com.example.aula_test.dto.funcionario.FuncionarioResquest;
import com.example.aula_test.model.Assento;
import com.example.aula_test.model.Funcionario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {
    
    private final AssentoMapper assentoMapper;

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

    public FuncionarioResponseAssento toResponseFuncionaioAssento(Funcionario funcionario, Assento assento){
        FuncionarioResponse funcionarioResponse = toResponse(funcionario);

        AssentoResponse assentoResponse = assentoMapper.toResponse(assento);
        
        return new FuncionarioResponseAssento(
        );
    }
}
