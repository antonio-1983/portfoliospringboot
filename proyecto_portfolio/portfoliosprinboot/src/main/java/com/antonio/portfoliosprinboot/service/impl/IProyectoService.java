/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.antonio.portfoliosprinboot.service.impl;

import com.antonio.portfoliosprinboot.entity.Proyecto;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IProyectoService {

    public List<Proyecto> verProyectos();
    public void crearProyecto(Proyecto proyecto);
    public void editarProyecto(Long id,Proyecto proyecto);
    public void eliminarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);

}
