/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.persistence;

import com.exmn.entity.RegistroPropiedad;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deyvi
 */
public interface IRegistroPropiedadDAO {
    List<RegistroPropiedad> findAll();

    Optional<RegistroPropiedad> findByID(int id);

    void save(RegistroPropiedad registroPropiedad);

    void deleteById(int id);
}
