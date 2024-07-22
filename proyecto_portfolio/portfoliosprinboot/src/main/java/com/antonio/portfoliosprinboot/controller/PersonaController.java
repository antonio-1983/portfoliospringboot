package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.Persona;
import com.antonio.portfoliosprinboot.service.impl.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona persona) {
        try {
            personaService.crearPersona(persona);
            return "Usuario creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarPersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {  
        try {
            personaService.editarPersona(id, personaDetalles);
            return "Usuario editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
        try {
            Persona persona = personaService.buscarPersona(id);
           return ResponseEntity.ok(persona);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<Persona>> verPersona(){
        try {
            List<Persona> personas =personaService.verPersona();
            return ResponseEntity.ok(personas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
