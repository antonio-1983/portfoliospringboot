package com.antonio.portfoliosprinboot.controller;
import com.antonio.portfoliosprinboot.entity.Conocimiento;
import com.antonio.portfoliosprinboot.service.impl.IConocimientoService;
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
@RequestMapping("api/conocimiento")
public class ConocimientoController {
    @Autowired
    private IConocimientoService conocimientoService;
    @PostMapping("/crear")
    public String crearConocimiento(@RequestBody Conocimiento conocimiento) {
        try {
            conocimientoService.crearConocimiento(conocimiento);
            return "Conocimiento creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarConocimiento(@PathVariable Long id, @RequestBody Conocimiento conocimientoDetalles) {  
        try {
            conocimientoService.editarConocimiento(id, conocimientoDetalles);
            return "Conocimiento editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Conocimiento> buscarConocimiento(@PathVariable Long id) {
        try {
            Conocimiento conocimiento = conocimientoService.buscarConocimiento(id);
           return ResponseEntity.ok(conocimiento);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<Conocimiento>> verConocimiento(){
        try {
            List<Conocimiento> conocimientos =conocimientoService.verConocimientos();
            return ResponseEntity.ok(conocimientos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }   
}
