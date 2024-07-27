package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.Proyecto;
import com.antonio.portfoliosprinboot.service.impl.IProyectoService;
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
@RequestMapping("api/proyecto")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;
    @PostMapping("/crear")
    public String crearProyecto(@RequestBody Proyecto proyecto) {
        try {
            proyectoService.crearProyecto(proyecto);
            return "Proyecto creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoDetalles) {  
        try {
            proyectoService.editarProyecto(id, proyectoDetalles);
            return "Proyecto editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable Long id) {
        try {
            Proyecto proyecto = proyectoService.buscarProyecto(id);
           return ResponseEntity.ok(proyecto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<Proyecto>> verProyectos(){
        try {
            List<Proyecto> proyectos =proyectoService.verProyectos();
            return ResponseEntity.ok(proyectos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }   
}
