/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers;

import com.exmn.controllers.dto.EditorialDTO;
import com.exmn.entity.Editorial;
import com.exmn.service.IEditorialService;
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
@RequestMapping("/api/editorial")
public class EditorialController {
    
    @Autowired
    private IEditorialService editorialService;
    
     @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable int id){
         Optional<Editorial> editorialOptional = editorialService.findById(id);
        if (editorialOptional.isPresent()){
            Editorial editorial = editorialOptional.get();
            
            EditorialDTO editorialDTO = EditorialDTO.builder()
                    .idEditorial(editorial.getIdEditorial())
                    .editorial(editorial.getEditorial())
                    .nombreDeContacto(editorial.getNombreDeContacto())
                    .direccion(editorial.getDireccion())
                    .ciudad(editorial.getCiudad())
                    .telefono(editorial.getTelefono())
                    .email(editorial.getEmail())
                    .comentario(editorial.getComentario())
                    .librosList(editorial.getLibros())
                    .build();
            return ResponseEntity.ok(editorialDTO);
        }
        return ResponseEntity.notFound().build();
     }
     
    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        List<EditorialDTO> editorialList = editorialService.findAll()
                .stream()
                .map(editorial -> EditorialDTO.builder()
                        .idEditorial(editorial.getIdEditorial())
                        .editorial(editorial.getEditorial())
                        .nombreDeContacto(editorial.getNombreDeContacto())
                        .direccion(editorial.getDireccion())
                        .ciudad(editorial.getCiudad())
                        .telefono(editorial.getTelefono())
                        .email(editorial.getEmail())
                        .comentario(editorial.getComentario())
                        .librosList(editorial.getLibros())
                        .build()).toList();
                return ResponseEntity.ok(editorialList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EditorialDTO editorialDTO) throws URISyntaxException {  //para indicarle que viene en el cuerpo de la peticion
        if (editorialDTO.getEditorial().isBlank() || editorialDTO.getNombreDeContacto().isBlank()) { //se puede agregar mas condiciones. esta vez solo lo hago con dos
            return ResponseEntity.badRequest().build();
        }
        editorialService.save(Editorial.builder()
                .editorial(editorialDTO.getEditorial())
                .nombreDeContacto(editorialDTO.getNombreDeContacto())
                .direccion(editorialDTO.getDireccion())
                .ciudad(editorialDTO.getCiudad())
                .telefono(editorialDTO.getTelefono())
                .email(editorialDTO.getEmail())
                .comentario(editorialDTO.getComentario())
                .build());
        return ResponseEntity.created(new URI("/api/editorial/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable int id, @RequestBody EditorialDTO editorialDTO){
        
        Optional<Editorial> editorialOptional=editorialService.findById(id);
        if (editorialOptional.isPresent()) {
            Editorial editorial = editorialOptional.get(); //recuperamos el objeto 'fabricante'
            
            editorial.setEditorial(editorialDTO.getEditorial());
            editorial.setNombreDeContacto(editorialDTO.getNombreDeContacto());
            editorial.setDireccion(editorialDTO.getDireccion());
            editorial.setCiudad(editorialDTO.getCiudad());
            editorial.setTelefono(editorialDTO.getTelefono());
            editorial.setEmail(editorialDTO.getEmail());
            editorial.setComentario(editorialDTO.getComentario());
            
            editorialService.save(editorial); //guardamos
            //Aqui devolvemos la respuesta que querramos, ya sea en JSON o no.
            //return ResponseEntity.ok("**msng: REgistro Exitoso**");
            //return ResponseEntity.ok().body("{\"message\": \"Registro actualizado exitosamente\"}");//formateado al json
            return ResponseEntity.ok(editorialDTO);//retornamos una persona para q el angular lo parsee a JSON xd
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if (id != 0) { //en caso de Long es posible comparar a Null, en este no.
            editorialService.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Registro Eliminado exitosamente\"}");//formateado al json
        }
        return ResponseEntity.badRequest().build();
    }
}
