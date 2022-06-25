package com.example.veterinaria.controller;

import com.example.veterinaria.entities.Veterinaria;
import com.example.veterinaria.service.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeterinariaController {

    private VeterinariaService veterinariaService;

    @Autowired
    public VeterinariaController(VeterinariaService veterinariaService) {
        this.veterinariaService = veterinariaService;
    }


    @PostMapping("/veterinarias")
    public Veterinaria guardar(@RequestBody Veterinaria veterinaria){
        return veterinariaService.guardar(veterinaria);
    }

    @GetMapping("/veterinarias")
    public List<Veterinaria> buscar(){
        return veterinariaService.buscar();
    }
}
