package com.example.aula_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula_test.model.Assento;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Long>{
    
}
