/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers;

import com.exmn.controllers.dto.LibroDTO;
import com.exmn.entity.Libro;
import com.exmn.service.ILibroService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deyvi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/libro")
public class LibroController {
    
    @Autowired
    private ILibroService libroService;
    
    @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable int id){
         Optional<Libro> libroOptional = libroService.findById(id);
        if (libroOptional.isPresent()){
            Libro libro = libroOptional.get();
            
            LibroDTO libroDTO = LibroDTO.builder()
                    .idLibro(libro.getIdLibro())
                    .iSBN(libro.getISBN())
                    .titulo(libro.getTitulo())
                    .autor(libro.getAutor())
                    .year(libro.getYear())
                    .precio(libro.getPrecio())
                    .comentarios(libro.getComentarios())
                    .fotoURL(libro.getFotoURL())
                    .editorial(libro.getEditorial()) //Esto está Bien. xq es una llave foranea
                    .registroPropiedad(libro.getRegistroPropiedad())
                    .build();
            return ResponseEntity.ok(libroDTO);
        }
        return ResponseEntity.notFound().build();
     }
     
    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        List<LibroDTO> librosList = libroService.findAll()
                .stream()
                .map(libro -> LibroDTO.builder()
                        .idLibro(libro.getIdLibro())
                        .iSBN(libro.getISBN())
                        .titulo(libro.getTitulo())
                        .autor(libro.getAutor())
                        .year(libro.getYear())
                        .precio(libro.getPrecio())
                        .comentarios(libro.getComentarios())
                        .fotoURL(libro.getFotoURL())
                        .editorial(libro.getEditorial())
                        .registroPropiedad(libro.getRegistroPropiedad())
                        .build()).toList();
                return ResponseEntity.ok(librosList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LibroDTO libroDTO) throws URISyntaxException {  //para indicarle que viene en el cuerpo de la peticion
        if (libroDTO.getPrecio()==0 || libroDTO.getISBN().isBlank()) { //se puede agregar mas condiciones. esta vez solo lo hago con dos
            return ResponseEntity.badRequest().build();
        }
        libroService.save(Libro.builder()
                .iSBN(libroDTO.getISBN())
                .titulo(libroDTO.getTitulo())
                .autor(libroDTO.getAutor())
                .year(libroDTO.getYear())
                .precio(libroDTO.getPrecio())
                .comentarios(libroDTO.getComentarios())
                .fotoURL(libroDTO.getFotoURL())
                .editorial(libroDTO.getEditorial())
                .build());
        return ResponseEntity.created(new URI("/api/libro/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable int id, @RequestBody LibroDTO libroDTO){
        
        Optional<Libro> libroOptional=libroService.findById(id);
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get(); //recuperamos el objeto 'fabricante'
            
            libro.setISBN(libroDTO.getISBN());
            libro.setTitulo(libroDTO.getTitulo());
            libro.setAutor(libroDTO.getAutor());
            libro.setYear(libroDTO.getYear());
            libro.setPrecio(libroDTO.getPrecio());
            libro.setComentarios(libroDTO.getComentarios());
            libro.setFotoURL(libroDTO.getFotoURL());
            libro.setEditorial(libroDTO.getEditorial());
            //libro.setRegistroPropiedad(libroDTO.getRegistroPropiedad());. TAMPOCO ESTE ES NECESARIO
            //(libro.setInventarios(libroDTO.getInventariosList()); NO ES NECESARIO USAR ESTO, xq botara error
            
            libroService.save(libro); //guardamos
            //Aqui devolvemos la respuesta que querramos, ya sea en JSON o no.
            //return ResponseEntity.ok("**msng: REgistro Exitoso**");
            //return ResponseEntity.ok().body("{\"message\": \"Registro actualizado exitosamente\"}");//formateado al json
            return ResponseEntity.ok(libroDTO);//retornamos una persona para q el angular lo parsee a JSON xd
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if (id != 0) { //en caso de Long es posible comparar a Null, en este no.
            libroService.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Registro Eliminado exitosamente\"}");//formateado al json
        }
        return ResponseEntity.badRequest().build();
    }
}
