package com.antonio.portfoliosprinboot.service;

import com.antonio.portfoliosprinboot.entity.Experiencia;
import com.antonio.portfoliosprinboot.repository.ExperienciaRepository;
import com.antonio.portfoliosprinboot.service.impl.IExperienciaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository experienciaRepository;
    
    @Override
    public List<Experiencia> verExperiencias(){
        return experienciaRepository.findAll();
    }
    @Override
    public void crearExperiencia(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }
    @Override
    public void editarExperiencia(Long id, Experiencia experiencia){
         Optional<Experiencia> optionalExperiencia = experienciaRepository.findById(id);
        
    if (optionalExperiencia.isPresent()) {
        Experiencia experienciaExistente = optionalExperiencia.get();   
        if (experiencia.getEmpresa() != null) {
            experienciaExistente.setEmpresa(experiencia.getEmpresa());
        }    
        if (experiencia.getDesde() != null) {
            experienciaExistente.setDesde(experiencia.getDesde());
        } 
        if(experiencia.getHasta() !=null){
            experienciaExistente.setHasta(experiencia.getHasta());
        }
        if(experiencia.getId_persona() !=null){
            experienciaExistente.setId_persona(experiencia.getId_persona());
        }
        if(experiencia.getPuesto() !=null){
            experienciaExistente.setPuesto(experiencia.getPuesto());
        }
            experienciaRepository.save(experienciaExistente);
    } else {
        throw new RuntimeException("Experiencia no encontrado");
    }  
  }
    
    @Override
    public Experiencia buscarExperiencia(Long id){
       return experienciaRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminarExperiencia(Long id){
       experienciaRepository.deleteById(id);
    }
    
}
