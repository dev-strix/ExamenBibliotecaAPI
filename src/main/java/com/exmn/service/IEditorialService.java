/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.service;

import com.exmn.entity.Editorial;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface IEditorialService {
    List<Editorial> findAll();

    Optional<Editorial> findById(int id);

    void save(Editorial editorial);

    void deleteById(int id); 
}
