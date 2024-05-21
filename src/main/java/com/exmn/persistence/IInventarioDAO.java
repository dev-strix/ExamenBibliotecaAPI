/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.persistence;

import com.exmn.entity.Inventario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface IInventarioDAO {
    List<Inventario> findAll();

    Optional<Inventario> findByID(int id);

    void save(Inventario inventario);

    void deleteById(int id);
}
