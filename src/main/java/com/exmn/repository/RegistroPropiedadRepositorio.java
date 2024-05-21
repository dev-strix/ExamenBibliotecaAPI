/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.exmn.repository;

import com.exmn.entity.RegistroPropiedad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author deyvi
 */
@Repository
public interface RegistroPropiedadRepositorio extends CrudRepository<RegistroPropiedad, Integer>{
    
}
