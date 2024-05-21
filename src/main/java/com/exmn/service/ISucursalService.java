/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.service;

import com.exmn.entity.Sucursal;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface ISucursalService {
    List<Sucursal> findAll();

    Optional<Sucursal> findById(int id);

    void save(Sucursal sucursal);

    void deleteById(int id);
}
