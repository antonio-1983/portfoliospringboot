package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.Experiencia;
import com.antonio.portfoliosprinboot.service.impl.IExperienciaService;
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
@RequestMapping("api/experiencia")
public class ExperienciaController {
    @Autowired
    private IExperienciaService experienciaService;
    @PostMapping("/crear")
    public String crearExperiencia(@RequestBody Experiencia experiencia) {
        try {
            experienciaService.crearExperiencia(experiencia);
            return "Experiencia creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaDetalles) {  
        try {
            experienciaService.editarExperiencia(id, experienciaDetalles);
            return "Experiencia editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable Long id) {
        try {
            Experiencia experiencia = experienciaService.buscarExperiencia(id);
           return ResponseEntity.ok(experiencia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<Experiencia>> verExperiencias(){
        try {
            List<Experiencia> experiencias =experienciaService.verExperiencias();
            return ResponseEntity.ok(experiencias);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }   
}


