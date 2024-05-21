/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.persistence;

import com.exmn.entity.Sucursal;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface ISucursalDAO {
    List<Sucursal> findAll();

    Optional<Sucursal> findByID(int id);

    void save(Sucursal sucursal);

    void deleteById(int id);
}
