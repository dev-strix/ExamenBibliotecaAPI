/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.service.impl;

import com.exmn.entity.RegistroPropiedad;
import com.exmn.persistence.IRegistroPropiedadDAO;
import com.exmn.service.IRegistroPropiedadService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deyvi
 */
@Service
public class RegistroServiceImpl implements IRegistroPropiedadService {

    @Autowired
    IRegistroPropiedadDAO propiedadDAO;

    @Override
    public List<RegistroPropiedad> findAll() {
        return propiedadDAO.findAll();
    }

    @Override
    public Optional<RegistroPropiedad> findById(int id) {
        return propiedadDAO.findByID(id);
    }

    @Override
    public void save(RegistroPropiedad registroPropiedad) {
        propiedadDAO.save(registroPropiedad);
    }

    @Override
    public void deleteById(int id) {
        propiedadDAO.deleteById(id);
    }

}
