/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.service.impl;

import com.exmn.entity.Editorial;
import com.exmn.persistence.IEditorialDAO;
import com.exmn.service.IEditorialService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deyvi
 */
@Service
public class EditorialServiceImpl implements IEditorialService {

    @Autowired
    IEditorialDAO editorialDAO;

    @Override
    public List<Editorial> findAll() {
        return editorialDAO.findAll();
    }

    @Override
    public Optional<Editorial> findById(int id) {
        return editorialDAO.findByID(id);
    }

    @Override
    public void save(Editorial editorial) {
        editorialDAO.save(editorial);
    }

    @Override
    public void deleteById(int id) {
        editorialDAO.deleteById(id);
    }
}
