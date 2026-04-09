package com.example.aula_test.dto.projeto;

import java.util.List;

import com.example.aula_test.model.Funcionario;

public record ProjetoResponse (

    long id,
    String nome,
    List<Funcionario> funcionarios
){
}
