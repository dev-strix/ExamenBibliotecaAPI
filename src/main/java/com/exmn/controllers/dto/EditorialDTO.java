/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers.dto;

import com.exmn.entity.Libro;
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
public class EditorialDTO {

    private int idEditorial;
    private String editorial;
    private String nombreDeContacto;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private String comentario;

    private List<Libro> librosList=new ArrayList<Libro>();
}
