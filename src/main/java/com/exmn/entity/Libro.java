/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    @Column(name = "iSBN")
    private String iSBN;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "year")
    private String year;
    @Column(name = "precio")
    private float precio;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "fotoURL")
    private String fotoURL;
    
    
    @ManyToOne()
    @JoinColumn(name = "idEditorial", nullable = false)
    @JsonIgnore
    private Editorial editorial;
    
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL)
    @JsonManagedReference
    private RegistroPropiedad registroPropiedad;
    
    //Relacion UNO a MUCHOS con inventario
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Inventario> inventarios;
    
    //Libro tiene una lista de inventarios. deberia ser similar a esto:
    // private List<Libro> librosList=new ArrayList<Libro>();
}
