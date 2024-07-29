package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.Educacion;
import com.antonio.portfoliosprinboot.service.impl.IEducacionService;
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
@RequestMapping("api/educacion")
public class EducacionController {
    @Autowired
    private IEducacionService educacionService;
    @PostMapping("/crear")
    public String crearEducacion(@RequestBody Educacion educacion) {
        try {
            educacionService.crearEducacion(educacion);
            return "Educacion creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarEducacion(@PathVariable Long id, @RequestBody Educacion educacionDetalles) {  
        try {
            educacionService.editarEducacion(id, educacionDetalles);
            return "Educacion editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable Long id) {
        try {
            Educacion educacion = educacionService.buscarEducacion(id);
           return ResponseEntity.ok(educacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<Educacion>> verEducaciones(){
        try {
            List<Educacion> educaciones =educacionService.verEducaciones();
            return ResponseEntity.ok(educaciones);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }   
}

