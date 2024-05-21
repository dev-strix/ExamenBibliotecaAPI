/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author deyvi
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;
    @Column(name = "existencia")
    private int existencia;
    
     //Relacion MUCHOS  a UNO con Sucursal
    @ManyToOne
    @JoinColumn(name = "idSucursal", nullable = false)
    @JsonIgnore
    private Sucursal sucursal;
    
    //Relacion MUCHOS  a UNO con Libro
    @ManyToOne
    @JoinColumn(name = "idLibro", nullable = false)
    @JsonIgnore
    private Libro libro;
}
