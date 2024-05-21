/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.service.impl;

import com.exmn.entity.Inventario;
import com.exmn.persistence.IInventarioDAO;
import com.exmn.service.IInventarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deyvi
 */
@Service
public class InventarioServiceImpl implements IInventarioService {

    @Autowired
    IInventarioDAO inventarioDAO;

    @Override
    public List<Inventario> findAll() {
        return inventarioDAO.findAll();
    }

    @Override
    public Optional<Inventario> findById(int id) {
        return inventarioDAO.findByID(id);
    }

    @Override
    public void save(Inventario inventario) {
        inventarioDAO.save(inventario);
    }

    @Override
    public void deleteById(int id) {
        inventarioDAO.deleteById(id);
    }
}
