/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers;

import com.exmn.controllers.dto.InventarioDTO;
import com.exmn.entity.Inventario;
import com.exmn.service.IInventarioService;
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
@RequestMapping("/api/inventario")
public class InventarioController {
    
    @Autowired
    private IInventarioService inventarioService;
    
    @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable int id){
         Optional<Inventario> inventarioOptional = inventarioService.findById(id);
        if (inventarioOptional.isPresent()){
            Inventario inventario = inventarioOptional.get();
            
            InventarioDTO inventarioDTO = InventarioDTO.builder()
                    .idInventario(inventario.getIdInventario())
                    .existencia(inventario.getExistencia())
                    .sucursal(inventario.getSucursal())
                    .libro(inventario.getLibro())
                    .build();
            return ResponseEntity.ok(inventarioDTO);
        }
        return ResponseEntity.notFound().build();
     }
    
     @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        List<InventarioDTO> inventarioList = inventarioService.findAll()
                .stream()
                .map(inventario -> InventarioDTO.builder()
                        .idInventario(inventario.getIdInventario())
                        .existencia(inventario.getExistencia())
                        .sucursal(inventario.getSucursal())
                        .libro(inventario.getLibro())
                        .build()).toList();
                return ResponseEntity.ok(inventarioList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InventarioDTO inventarioDTO) throws URISyntaxException {  //para indicarle que viene en el cuerpo de la peticion
        if (inventarioDTO.getLibro()==null || inventarioDTO.getExistencia()==0) { //se puede agregar mas condiciones. esta vez solo lo hago con dos
            return ResponseEntity.badRequest().build();
        }
        inventarioService.save(Inventario.builder()
                        .existencia(inventarioDTO.getExistencia())
                        .sucursal(inventarioDTO.getSucursal())
                        .libro(inventarioDTO.getLibro())
                .build());
        return ResponseEntity.created(new URI("/api/inventario/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInventario(@PathVariable int id, @RequestBody InventarioDTO inventarioDTO){
        
        Optional<Inventario> inventarioOptional=inventarioService.findById(id);
        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get(); //recuperamos el objeto 'fabricante'
           
            inventario.setExistencia(inventarioDTO.getExistencia());
            inventario.setSucursal(inventarioDTO.getSucursal());
            inventario.setLibro(inventarioDTO.getLibro());
            
            inventarioService.save(inventario); //guardamos
            //Aqui devolvemos la respuesta que querramos, ya sea en JSON o no.
            //return ResponseEntity.ok("**msng: REgistro Exitoso**");
            //return ResponseEntity.ok().body("{\"message\": \"Registro actualizado exitosamente\"}");//formateado al json
            return ResponseEntity.ok(inventarioDTO);//retornamos una persona para q el angular lo parsee a JSON xd
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if (id != 0) { //en caso de Long es posible comparar a Null, en este no.
            inventarioService.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Registro Eliminado exitosamente\"}");//formateado al json
        }
        return ResponseEntity.badRequest().build();
    }
}
