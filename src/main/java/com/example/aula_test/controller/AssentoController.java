package com.example.aula_test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.aula_test.dto.assento.AssentoRequest;
import com.example.aula_test.dto.assento.AssentoResponse;
import com.example.aula_test.service.AssentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Assento")
public class AssentoController {

    private final AssentoService service;

    @PostMapping("/create")
    public ResponseEntity<AssentoResponse> create(@RequestBody AssentoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<AssentoResponse>> listar() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<AssentoResponse> listarPorId(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AssentoResponse> update(@PathVariable long id,
                                                     @RequestBody AssentoRequest dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}