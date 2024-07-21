package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.Persona;
import com.antonio.portfoliosprinboot.service.impl.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/buscar/{id}")
    public String desactivarPersona(@PathVariable Long id) {
        try {
            personaService.buscarPersona(id);
            return "Usuario "+id;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
