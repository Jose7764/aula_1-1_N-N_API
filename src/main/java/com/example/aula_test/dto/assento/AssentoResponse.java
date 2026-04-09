package com.example.aula_test.dto.assento;

import com.example.aula_test.model.Funcionario;

public record AssentoResponse (

    long id, 
    String codigo,
    Funcionario funcionario
){
}
