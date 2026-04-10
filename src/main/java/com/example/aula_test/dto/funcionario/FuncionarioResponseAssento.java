package com.example.aula_test.dto.funcionario;

import com.example.aula_test.dto.assento.AssentoResponse;

public record FuncionarioResponseAssento(
    FuncionarioResponse funcionario,
    AssentoResponse assento
) {
    
}
