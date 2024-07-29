
package com.antonio.portfoliosprinboot.service.impl;

import com.antonio.portfoliosprinboot.entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public List<Experiencia> verExperiencias();
    public void crearExperiencia(Experiencia experiencia);
    public void editarExperiencia(Long id,Experiencia experiencia);
    public void eliminarExperiencia(Long id);
    public Experiencia buscarExperiencia(Long id);
    
}
