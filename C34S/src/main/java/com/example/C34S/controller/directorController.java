package com.example.C34S.controller;

import com.example.C34S.model.DirectorTecnico;
import com.example.C34S.model.Jugador;
import com.example.C34S.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class directorController {


    @Autowired
    TecnicoService tecnicoService;


    @PostMapping("/tecnico/nuevo")
    public ResponseEntity<DirectorTecnico> nuevoOdontologo(@RequestBody DirectorTecnico tecnico){
        return ResponseEntity.ok(tecnicoService.guardar(tecnico)) ;
    }

}
