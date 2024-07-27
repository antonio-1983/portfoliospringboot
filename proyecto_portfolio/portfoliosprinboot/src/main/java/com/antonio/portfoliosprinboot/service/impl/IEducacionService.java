package com.antonio.portfoliosprinboot.service.impl;

import com.antonio.portfoliosprinboot.entity.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducaciones();
    public void crearEducacion(Educacion educacion);
    public void editarEducacion(Long id,Educacion educacion);
    public void eliminarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    
}
