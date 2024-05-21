/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers.dto;

import com.exmn.entity.Libro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author deyvi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor //@Builder
@Builder
public class RegistroPropiedadDTO {

    private int idRegProp;
    private String codigoReg; //es solo un adicional
    
    private Libro libro;
}
