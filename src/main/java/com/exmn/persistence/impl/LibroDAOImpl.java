/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.persistence.impl;

import com.exmn.entity.Libro;
import com.exmn.persistence.ILibroDAO;
import com.exmn.repository.LibroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author deyvi
 */
@Component
public class LibroDAOImpl implements ILibroDAO {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> findAll() {
        return (List<Libro>) libroRepositorio.findAll();
    }

    @Override
    public Optional<Libro> findByID(int id) {
        return libroRepositorio.findById(id);
    }

    @Override
    public void save(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void deleteById(int id) {
        libroRepositorio.deleteById(id);
    }

}
