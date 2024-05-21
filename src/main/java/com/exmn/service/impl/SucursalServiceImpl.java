/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.service.impl;

import com.exmn.entity.Sucursal;
import com.exmn.persistence.ISucursalDAO;
import com.exmn.service.ISucursalService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deyvi
 */
@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    ISucursalDAO sucursalDAO;

    @Override
    public List<Sucursal> findAll() {
        return sucursalDAO.findAll();
    }

    @Override
    public Optional<Sucursal> findById(int id) {
        return sucursalDAO.findByID(id);
    }

    @Override
    public void save(Sucursal sucursal) {
        sucursalDAO.save(sucursal);
    }

    @Override
    public void deleteById(int id) {
        sucursalDAO.deleteById(id);
    }

}
