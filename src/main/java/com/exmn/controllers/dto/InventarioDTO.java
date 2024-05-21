/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers.dto;

import com.exmn.entity.Libro;
import com.exmn.entity.Sucursal;
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
public class InventarioDTO {
    
    private int idInventario;
    private int existencia;
    
    private Sucursal sucursal;
    
    private Libro libro;
}
