package com.antonio.portfoliosprinboot.repository;

import com.antonio.portfoliosprinboot.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
}
