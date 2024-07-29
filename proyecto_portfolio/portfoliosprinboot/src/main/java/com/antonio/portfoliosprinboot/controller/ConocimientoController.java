package com.antonio.portfoliosprinboot.controller;
import com.antonio.portfoliosprinboot.repository.ConocimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/conocimiento")
public class ConocimientoController {
    @Autowired
    ConocimientoRepository conocimientoRepository;
    
   // @PostMapping("/crear")
    
}
