/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.persistence.impl;

import com.exmn.entity.Editorial;
import com.exmn.persistence.IEditorialDAO;
import com.exmn.repository.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author deyvi
 */
@Component
public class EditorialDAOImpl implements IEditorialDAO {

    @Autowired
    private EditorialRepositorio editorialRepository;

    @Override
    public List<Editorial> findAll() {
        return (List<Editorial>) editorialRepository.findAll();
    }

    @Override
    public Optional<Editorial> findByID(int id) {
        return editorialRepository.findById(id);
    }

    @Override
    public void save(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    @Override
    public void deleteById(int id) {
        editorialRepository.deleteById(id);
    }
}
