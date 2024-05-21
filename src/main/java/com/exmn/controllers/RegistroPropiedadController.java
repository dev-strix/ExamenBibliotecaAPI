/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exmn.controllers;

import com.exmn.controllers.dto.RegistroPropiedadDTO;
import com.exmn.entity.RegistroPropiedad;
import com.exmn.service.IRegistroPropiedadService;
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
@RequestMapping("/api/registroPropiedad")
public class RegistroPropiedadController {
    
    @Autowired
    private IRegistroPropiedadService registroPropiedadService;
    
    @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable int id){
         Optional<RegistroPropiedad> rpOptional = registroPropiedadService.findById(id);
        if (rpOptional.isPresent()){
            RegistroPropiedad rp = rpOptional.get();
            
            RegistroPropiedadDTO registroPropiedadDTO = RegistroPropiedadDTO.builder()
                    .idRegProp(rp.getIdRegProp())
                    .codigoReg(rp.getCodigoReg())
                    .libro(rp.getLibro())
                    .build();
            return ResponseEntity.ok(registroPropiedadDTO);
        }
        return ResponseEntity.notFound().build();
     }
     
     @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        List<RegistroPropiedadDTO> rpList = registroPropiedadService.findAll()
                .stream()
                .map(rp -> RegistroPropiedadDTO.builder()
                        .idRegProp(rp.getIdRegProp())
                        .codigoReg(rp.getCodigoReg())
                        .libro(rp.getLibro())
                        .build()).toList();
                return ResponseEntity.ok(rpList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegistroPropiedadDTO rpDTO) throws URISyntaxException {  //para indicarle que viene en el cuerpo de la peticion
        if (rpDTO.getCodigoReg().isBlank()) { //se puede agregar mas condiciones. esta vez solo lo hago con dos
            return ResponseEntity.badRequest().build();
        }
        registroPropiedadService.save(RegistroPropiedad.builder()
                .codigoReg(rpDTO.getCodigoReg())
                .libro(rpDTO.getLibro())
                .build());
        return ResponseEntity.created(new URI("/api/registroPropiedad/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable int id, @RequestBody RegistroPropiedadDTO rpDTO){
        
        Optional<RegistroPropiedad> rpOptional=registroPropiedadService.findById(id);
        if (rpOptional.isPresent()) {
            RegistroPropiedad rp = rpOptional.get(); //recuperamos el objeto 'fabricante'
            
            rp.setCodigoReg(rpDTO.getCodigoReg());
            rp.setLibro(rpDTO.getLibro());
            
            registroPropiedadService.save(rp); //guardamos
            //Aqui devolvemos la respuesta que querramos, ya sea en JSON o no.
            //return ResponseEntity.ok("**msng: REgistro Exitoso**");
            //return ResponseEntity.ok().body("{\"message\": \"Registro actualizado exitosamente\"}");//formateado al json
            return ResponseEntity.ok(rpDTO);//retornamos una persona para q el angular lo parsee a JSON xd
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if (id != 0) { //en caso de Long es posible comparar a Null, en este no.
            registroPropiedadService.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Registro Eliminado exitosamente\"}");//formateado al json
        }
        return ResponseEntity.badRequest().build();
    }
}
