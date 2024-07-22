package com.antonio.portfoliosprinboot.service;
import com.antonio.portfoliosprinboot.entity.Conocimiento;
import com.antonio.portfoliosprinboot.repository.ConocimientoRepository;
import com.antonio.portfoliosprinboot.service.impl.IConocimientoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConocimientoService implements IConocimientoService{
    @Autowired
    public ConocimientoRepository conocimientoRepository;
    
    @Override
    public List<Conocimiento> verConocimientos(){
        return conocimientoRepository.findAll();
    }
    @Override
    public void crearConocimiento(Conocimiento conocimiento){
        conocimientoRepository.save(conocimiento);
    }
    @Override
    public void editarConocimiento(Long id, Conocimiento conocimiento){
         Optional<Conocimiento> optionalConocimiento = conocimientoRepository.findById(id);
        
    if (optionalConocimiento.isPresent()) {
        Conocimiento conocimientoExistente = optionalConocimiento.get();
        
        if (conocimiento.getEmpresa() != null) {
            conocimientoExistente.setEmpresa(conocimiento.getEmpresa());
        }
        if (conocimiento.getPuesto() != null) {
            conocimientoExistente.setPuesto(conocimiento.getPuesto());
        }
        if (conocimiento.getDesde() != null) {
            conocimientoExistente.setDesde(conocimiento.getDesde());
        }
        if (conocimiento.getHasta() != null) {
            conocimientoExistente.setHasta(conocimiento.getHasta());
        }          
        if(conocimiento.getId_persona() !=null){
            conocimientoExistente.setId_persona(conocimiento.getId_persona());
        }
            conocimientoRepository.save(conocimientoExistente);
    } else {
        throw new RuntimeException("Conocimiento no encontrado");
    }       
  }
    
    @Override
    public Conocimiento buscarConocimiento(Long id){
       return conocimientoRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminarConocimiento(Long id){
        conocimientoRepository.deleteById(id);
    }
}
