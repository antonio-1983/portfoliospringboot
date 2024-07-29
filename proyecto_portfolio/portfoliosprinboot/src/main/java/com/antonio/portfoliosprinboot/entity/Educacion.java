package com.antonio.portfoliosprinboot.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String titulo;
    private String desde;
    private String hasta;
    private Long id_persona;
    private String img_educacion;
}
