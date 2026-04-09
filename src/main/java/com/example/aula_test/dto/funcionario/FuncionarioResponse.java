package com.example.aula_test.dto.funcionario;

import java.util.List;

import com.example.aula_test.model.Assento;
import com.example.aula_test.model.Projeto;

public record FuncionarioResponse (

    long id, 
    String nome, 
    Assento assento,
    List<Projeto> projetos
){
}
