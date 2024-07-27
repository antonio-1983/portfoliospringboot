package com.antonio.portfoliosprinboot.service;

import com.antonio.portfoliosprinboot.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.codec.Base64;
import com.antonio.portfoliosprinboot.repository.UserRepository;
import com.antonio.portfoliosprinboot.service.impl.IUserService;

@Service
public class UserService implements IUserService{
    
    @Autowired
    public UserRepository userRepo;
    
    @Override
    public List<User> verUser() {
      return userRepo.findAll();
    }

    @Override
    public void crearUser(User user) {
        String encodedPassword = new String(Base64.encode(user.getPassword().getBytes()));
        user.setPassword(encodedPassword);
        userRepo.save(user);
    }

    @Override
    public User buscarUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean checkPassword(User user, String rawPassword) {
        String encodedPassword = new String(Base64.encode(rawPassword.getBytes()));
        return encodedPassword.equals(user.getPassword());
    }    
    @Override
    public void editarUser(Long id, User userDetalles) {
        Optional<User> optionalUser = userRepo.findById(id);
    if (optionalUser.isPresent()) {
        User userExistente = optionalUser.get();
        
        if (userDetalles.getNombre() != null) {
            userExistente.setNombre(userDetalles.getNombre());
        }
        if(userDetalles.getPassword()!= null){
            String encodedPassword = new String(Base64.encode(userDetalles.getPassword().getBytes()));
            userExistente.setPassword(encodedPassword);
        }
        if (userDetalles.getApellido() != null) {
            userExistente.setApellido(userDetalles.getApellido());
        }
        if (userDetalles.getEmail() != null) {
            userExistente.setEmail(userDetalles.getEmail());
        }
        if (userDetalles.getTelefono() != 0) {
            userExistente.setTelefono(userDetalles.getTelefono());
        }          
        if(userDetalles.getLinkedin() !=null){
            userExistente.setLinkedin(userDetalles.getLinkedin());
        }
        if(userDetalles.getGithub() !=null){
            userExistente.setGithub(userDetalles.getGithub());
        }
            userRepo.save(userExistente);
    } else {
        throw new RuntimeException("Usuario no encontrado");
    }
   }
    
    
}
