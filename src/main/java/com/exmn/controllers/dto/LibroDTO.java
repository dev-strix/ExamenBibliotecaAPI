/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers.dto;

import com.exmn.entity.Editorial;
import com.exmn.entity.Inventario;
import com.exmn.entity.RegistroPropiedad;
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
public class LibroDTO {
    
    private int idLibro;
    private String iSBN;
    private String titulo;
    private String autor;
    private String year;
    private float precio;
    private String comentarios;
    private String fotoURL;
    
    private Editorial editorial;
    
    private RegistroPropiedad registroPropiedad;

    private List<Inventario> inventariosList = new ArrayList<Inventario>();
}
