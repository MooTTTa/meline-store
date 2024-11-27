package com.meline.store.controller;


import com.meline.store.dto.ClothesRequestDTO;
import com.meline.store.dto.ClothesResponseDTO;
import com.meline.store.dto.EditRequestDTO;
import com.meline.store.dto.RegisterDTO;
import com.meline.store.model.Clothes;
import com.meline.store.services.ClothesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clothes")
public class ClothesController {


    @Autowired
    private ClothesServices service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<ClothesResponseDTO>> getAllClothes(){
       return new ResponseEntity<>(service.getAllClothes(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> clothes(@RequestBody ClothesRequestDTO clothes){
        service.registerClothes(clothes);
        return new ResponseEntity<>(new RegisterDTO("Roupa " + clothes.name() + " cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*") // atualizar restricao dominio para apenas o front conectar
    @PatchMapping("/edit")
       public Clothes editClothes(@RequestBody EditRequestDTO dto){
        return service.editClothes(dto);
    }
}
