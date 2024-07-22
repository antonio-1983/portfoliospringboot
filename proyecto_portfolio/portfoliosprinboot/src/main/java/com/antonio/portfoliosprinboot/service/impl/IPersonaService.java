package com.antonio.portfoliosprinboot.service.impl;

import com.antonio.portfoliosprinboot.entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> verPersona();
    public void crearPersona(Persona p);
    public Persona buscarPersona (Long id);
    public void editarPersona (Long id, Persona personaDetalles);
}
