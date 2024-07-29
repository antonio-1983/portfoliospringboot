package com.antonio.portfoliosprinboot.controller;

import com.antonio.portfoliosprinboot.entity.User;
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
import com.antonio.portfoliosprinboot.service.impl.IUserService;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/hola")
    public String hola (){
        return "hola mundo";
    }
    @PostMapping("/crear")
    public String crearUser(@RequestBody User user) {
        try {
            userService.crearUser(user);
            return "Usuario creado exitosamente";
        }
        catch(RuntimeException e)
        {
            return e.getMessage();
        }
    }

    @PutMapping("/editar/{id}")
    public String editarUser(@PathVariable Long id, @RequestBody User userDetalles) {  
        try {
            userService.editarUser(id, userDetalles);
            return "Usuario editado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<User> buscarUser(@PathVariable Long id) {
        try {
            User user = userService.buscarUser(id);
           return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ver")
    public ResponseEntity<List<User>> verUser(){
        try {
            List<User> users =userService.verUser();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
