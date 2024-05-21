/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.persistence.impl;

import com.exmn.entity.Inventario;
import com.exmn.persistence.IInventarioDAO;
import com.exmn.repository.InventarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author deyvi
 */
@Component
public class InventarioDAOImpl implements IInventarioDAO {

    @Autowired
    private InventarioRepositorio inventarioRepositorio;

    @Override
    public List<Inventario> findAll() {
        return (List<Inventario>) inventarioRepositorio.findAll();
    }

    @Override
    public Optional<Inventario> findByID(int id) {
        return inventarioRepositorio.findById(id);
    }

    @Override
    public void save(Inventario inventario) {
        inventarioRepositorio.save(inventario);
    }

    @Override
    public void deleteById(int id) {
        inventarioRepositorio.deleteById(id);
    }

}
