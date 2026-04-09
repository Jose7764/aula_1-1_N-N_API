package com.example.aula_test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.aula_test.dto.projeto.ProjetoRequest;
import com.example.aula_test.dto.projeto.ProjetoResponse;
import com.example.aula_test.service.ProjetoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/<entidade>")
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping("/create")
    public ResponseEntity<ProjetoResponse> create(@RequestBody ProjetoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ProjetoResponse>> listar() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ProjetoResponse> listarPorId(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjetoResponse> update(@PathVariable long id,
                                                     @RequestBody ProjetoRequest dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}