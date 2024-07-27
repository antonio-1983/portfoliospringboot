package com.antonio.portfoliosprinboot.service;

import com.antonio.portfoliosprinboot.entity.Educacion;
import com.antonio.portfoliosprinboot.repository.EducacionRepository;
import com.antonio.portfoliosprinboot.service.impl.IEducacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository educacionRepository;
    
    @Override
    public List<Educacion> verEducaciones(){
        return educacionRepository.findAll();
    }
    @Override
    public void crearEducacion(Educacion educacion){
        educacionRepository.save(educacion);
    }
    @Override
    public void editarEducacion(Long id, Educacion educacion){
         Optional<Educacion> optionalEducacion = educacionRepository.findById(id);
        
    if (optionalEducacion.isPresent()) {
        Educacion educacionExistente = optionalEducacion.get();
    
       //*********************************************
        if (educacion.getNombre() != null) {
            educacionExistente.setNombre(educacion.getNombre());
        }    
        if (educacion.getTitulo() != null) {
            educacionExistente.setTitulo(educacion.getTitulo());
        } 
        if(educacion.getId_persona() !=null){
            educacionExistente.setId_persona(educacion.getId_persona());
        }
        if(educacion.getDesde() !=null){
            educacionExistente.setDesde(educacion.getDesde());
        }
        if(educacion.getHasta() !=null){
            educacionExistente.setHasta(educacion.getHasta());
        }
            educacionRepository.save(educacionExistente);
    } else {
        throw new RuntimeException("Conocimiento no encontrado");
    } 
    //*****************************************************
    
  }
    
    @Override
    public Educacion buscarEducacion(Long id){
       return educacionRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminarEducacion(Long id){
        educacionRepository.deleteById(id);
    }
}
