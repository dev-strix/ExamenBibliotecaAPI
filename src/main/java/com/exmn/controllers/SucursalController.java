/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers;

import com.exmn.controllers.dto.SucursalDTO;
import com.exmn.entity.Sucursal;
import com.exmn.service.ISucursalService;
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
@RequestMapping("/api/sucursal")
public class SucursalController {
    
    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable int id){
         Optional<Sucursal> sucursalOptional = sucursalService.findById(id);
        if (sucursalOptional.isPresent()){
            Sucursal sucursal = sucursalOptional.get();
            
            SucursalDTO sucursalDTO = SucursalDTO.builder()
                    .idSucursal(sucursal.getIdSucursal())
                    .sucursal(sucursal.getSucursal())
                    .nombreEncargado(sucursal.getNombreEncargado())
                    .direccion(sucursal.getDireccion())
                    .ciudad(sucursal.getCiudad())
                    .telefono(sucursal.getTelefono())
                    .email(sucursal.getEmail())
                    .comentario(sucursal.getComentario())
                    .inventariosList(sucursal.getInventarios()) //responable de retornar los inventarios de la sucursal
                    .build();
            return ResponseEntity.ok(sucursalDTO);
        }
        return ResponseEntity.notFound().build();
     }
    
     @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        List<SucursalDTO> sucursallList = sucursalService.findAll()
                .stream()
                .map(sucursal -> SucursalDTO.builder()
                        .idSucursal(sucursal.getIdSucursal())
                        .sucursal(sucursal.getSucursal())
                        .nombreEncargado(sucursal.getNombreEncargado())
                        .direccion(sucursal.getDireccion())
                        .ciudad(sucursal.getCiudad())
                        .telefono(sucursal.getTelefono())
                        .email(sucursal.getEmail())
                        .comentario(sucursal.getComentario())
                        .inventariosList(sucursal.getInventarios())
                        .build()).toList();
                return ResponseEntity.ok(sucursallList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SucursalDTO sucursalDTO) throws URISyntaxException {  //para indicarle que viene en el cuerpo de la peticion
        if (sucursalDTO.getDireccion().isBlank() || sucursalDTO.getTelefono().isBlank()) { //se puede agregar mas condiciones. esta vez solo lo hago con dos
            return ResponseEntity.badRequest().build();
        }
        sucursalService.save(Sucursal.builder()
                
                .sucursal(sucursalDTO.getSucursal())
                .nombreEncargado(sucursalDTO.getNombreEncargado())
                .direccion(sucursalDTO.getDireccion())
                .ciudad(sucursalDTO.getCiudad())
                .telefono(sucursalDTO.getTelefono())
                .email(sucursalDTO.getEmail())
                .comentario(sucursalDTO.getComentario())
                .build());
        //no es necesario enviar inventarios aunque este forme parte de esta entidad relacional, solo las variables basicas
        return ResponseEntity.created(new URI("/api/sucursal/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable int id, @RequestBody SucursalDTO sucursalDTO){
        
        Optional<Sucursal> sucursalOptional=sucursalService.findById(id);
        if (sucursalOptional.isPresent()) {
            Sucursal sucursal = sucursalOptional.get(); //recuperamos el objeto 'fabricante'
            
            sucursal.setSucursal(sucursalDTO.getSucursal());
            sucursal.setNombreEncargado(sucursalDTO.getNombreEncargado());
            sucursal.setDireccion(sucursalDTO.getDireccion());
            sucursal.setCiudad(sucursalDTO.getCiudad());
            sucursal.setTelefono(sucursalDTO.getTelefono());
            sucursal.setEmail(sucursalDTO.getEmail());
            sucursal.setComentario(sucursalDTO.getComentario());
            
            //Obiamos el envio de Inventarios xq no es NECESARIO..........................::::::::::::::::::[SOLUCIONADO]::::::::::::::::::::::::::::
            //sucursal.setInventarios(sucursalDTO.getInventariosList());
            
            sucursalService.save(sucursal); //guardamos

            return ResponseEntity.ok(sucursalDTO);//retornamos una persona para q el angular lo parsee a JSON xd
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if (id != 0) { //en caso de Long es posible comparar a Null, en este no.
            sucursalService.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Registro Eliminado exitosamente\"}");//formateado al json
        }
        return ResponseEntity.badRequest().build();
    }
}
