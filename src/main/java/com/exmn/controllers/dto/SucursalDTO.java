/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers.dto;

import com.exmn.entity.Inventario;
import java.util.ArrayList;
import java.util.List;
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
public class SucursalDTO {

    private int idSucursal;
    private String sucursal;
    private String nombreEncargado;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private String comentario;

    private List<Inventario> inventariosList = new ArrayList<Inventario>();
}
