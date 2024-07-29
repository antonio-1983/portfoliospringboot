package com.antonio.portfoliosprinboot.service;

import com.antonio.portfoliosprinboot.entity.Proyecto;
import com.antonio.portfoliosprinboot.repository.ProyectoRepository;
import com.antonio.portfoliosprinboot.service.impl.IProyectoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proyectoRepository;
    
    @Override
    public List<Proyecto> verProyectos(){
        return proyectoRepository.findAll();
    }
    @Override
    public void crearProyecto(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    @Override
    public void editarProyecto(Long id, Proyecto proyecto){
         Optional<Proyecto> optionalProyecto = proyectoRepository.findById(id);
        
    if (optionalProyecto.isPresent()) {
        Proyecto proyectoExistente = optionalProyecto.get();   
        if (proyecto.getDescripcion() != null) {
            proyectoExistente.setDescripcion(proyecto.getDescripcion());
        }    
        if (proyecto.getImagen() != null) {
            proyectoExistente.setImagen(proyecto.getImagen());
        }
        if (proyecto.getRepositorio() != null) {
            proyectoExistente.setRepositorio(proyecto.getRepositorio());
        }
            proyectoRepository.save(proyectoExistente);
    } else {
        throw new RuntimeException("Proyecto no encontrado");
    }  
  }
    
    @Override
    public Proyecto buscarProyecto(Long id){
       return proyectoRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminarProyecto(Long id){
       proyectoRepository.deleteById(id);
    }
    
}
