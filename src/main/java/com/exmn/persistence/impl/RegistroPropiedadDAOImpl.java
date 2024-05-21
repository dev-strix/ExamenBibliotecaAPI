/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.persistence.impl;

import com.exmn.entity.RegistroPropiedad;
import com.exmn.persistence.IRegistroPropiedadDAO;
import com.exmn.repository.RegistroPropiedadRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author deyvi
 */
@Component
public class RegistroPropiedadDAOImpl implements IRegistroPropiedadDAO {

    @Autowired
    private RegistroPropiedadRepositorio registroPropiedadRepositorio;

    @Override
    public List<RegistroPropiedad> findAll() {
        return (List<RegistroPropiedad>) registroPropiedadRepositorio.findAll();
    }

    @Override
    public Optional<RegistroPropiedad> findByID(int id) {
        return registroPropiedadRepositorio.findById(id);
    }

    @Override
    public void save(RegistroPropiedad registroPropiedad) {
        registroPropiedadRepositorio.save(registroPropiedad);
    }

    @Override
    public void deleteById(int id) {
        registroPropiedadRepositorio.deleteById(id);
    }

}
