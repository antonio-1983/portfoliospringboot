package com.antonio.portfoliosprinboot.service.impl;
import com.antonio.portfoliosprinboot.entity.Conocimiento;
import java.util.List;

public interface IConocimientoService {
    public List<Conocimiento> verConocimientos();
    public void crearConocimiento(Conocimiento conocimiento);
    public void editarConocimiento(Long id,Conocimiento conocimiento);
    public void eliminarConocimiento(Long id);
    public Conocimiento buscarConocimiento(Long id);
    }
