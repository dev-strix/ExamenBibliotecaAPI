/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.persistence.impl;

import com.exmn.entity.Sucursal;
import com.exmn.persistence.ISucursalDAO;
import com.exmn.repository.SucursalRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author deyvi
 */
@Component
public class SucursalDAOImpl implements ISucursalDAO {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    @Override
    public List<Sucursal> findAll() {
        return (List<Sucursal>) sucursalRepositorio.findAll();
    }

    @Override
    public Optional<Sucursal> findByID(int id) {
        return sucursalRepositorio.findById(id);
    }

    @Override
    public void save(Sucursal sucursal) {
        sucursalRepositorio.save(sucursal);
    }

    @Override
    public void deleteById(int id) {
        sucursalRepositorio.deleteById(id);
    }

}
