package com.antonio.portfoliosprinboot.service.impl;

import com.antonio.portfoliosprinboot.entity.User;
import java.util.List;

public interface IUserService {
    public List<User> verUser();
    public void crearUser(User user);
    public User buscarUser (Long id);
    public void editarUser (Long id, User userDetalles);
}
