/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.service.impl;

import com.exmn.entity.Libro;
import com.exmn.persistence.ILibroDAO;
import com.exmn.service.ILibroService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deyvi
 */
@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    ILibroDAO libroDAO;

    @Override
    public List<Libro> findAll() {
        return libroDAO.findAll();
    }

    @Override
    public Optional<Libro> findById(int id) {
        return libroDAO.findByID(id);
    }

    @Override
    public void save(Libro libro) {
        libroDAO.save(libro);
    }

    @Override
    public void deleteById(int id) {
        libroDAO.deleteById(id);
    }

}
