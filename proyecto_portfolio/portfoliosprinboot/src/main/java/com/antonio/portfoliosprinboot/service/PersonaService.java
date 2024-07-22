package com.antonio.portfoliosprinboot.service;

import com.antonio.portfoliosprinboot.entity.Persona;
import com.antonio.portfoliosprinboot.repository.PersonaRepository;
import com.antonio.portfoliosprinboot.service.impl.IPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository personaRepo;
    
    @Override
    public List<Persona> verPersona() {
      return personaRepo.findAll();
    }

    @Override
    public void crearPersona(Persona p) {
      personaRepo.save(p);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }
    
    @Override
    public void editarPersona(Long id, Persona personaDetalles) {
        Optional<Persona> optionalPersona = personaRepo.findById(id);
    if (optionalPersona.isPresent()) {
        Persona personaExistente = optionalPersona.get();
        
        if (personaDetalles.getNombre() != null) {
            personaExistente.setNombre(personaDetalles.getNombre());
        }
        if (personaDetalles.getApellido() != null) {
            personaExistente.setApellido(personaDetalles.getApellido());
        }
        if (personaDetalles.getEmail() != null) {
            personaExistente.setEmail(personaDetalles.getEmail());
        }
        if (personaDetalles.getTelefono() != 0) {
            personaExistente.setTelefono(personaDetalles.getTelefono());
        }          
        if(personaDetalles.getLinkedin() !=null){
            personaExistente.setLinkedin(personaDetalles.getLinkedin());
        }
        if(personaDetalles.getGithub() !=null){
            personaExistente.setGithub(personaDetalles.getGithub());
        }
            personaRepo.save(personaExistente);
    } else {
        throw new RuntimeException("Usuario no encontrado");
    }
   }
}
