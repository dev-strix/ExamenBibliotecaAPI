/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.persistence;

import com.exmn.entity.Libro;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface ILibroDAO {
    List<Libro> findAll();

    Optional<Libro> findByID(int id);

    void save(Libro libro);

    void deleteById(int id);
}
