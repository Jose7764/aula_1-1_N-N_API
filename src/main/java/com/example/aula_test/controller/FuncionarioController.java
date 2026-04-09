package com.example.aula_test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula_test.dto.funcionario.FuncionarioResponse;
import com.example.aula_test.dto.funcionario.FuncionarioResquest;
import com.example.aula_test.service.FuncionarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService service;

    @PostMapping("/create")
    public ResponseEntity<FuncionarioResponse> create(@RequestBody FuncionarioResquest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<FuncionarioResponse>> listar(){
        return ResponseEntity.status(HttpStatus.OK)
        .body(service.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<FuncionarioResponse> listarPorId(@PathVariable long id ){
        return ResponseEntity.status(HttpStatus.OK)
        .body(service.listById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FuncionarioResponse> update(@PathVariable long id, @RequestBody FuncionarioResquest dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(service.update(id, dto));
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .build();
    }

}
