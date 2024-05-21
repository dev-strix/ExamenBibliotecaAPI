/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.service;

//import com.exmn.entity.Editorial;
import com.exmn.entity.Inventario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface IInventarioService {
    List<Inventario> findAll();

    Optional<Inventario> findById(int id);

    void save(Inventario inventario);

    void deleteById(int id); 
}
