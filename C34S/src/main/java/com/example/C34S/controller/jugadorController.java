package com.example.C34S.controller;

import com.example.C34S.model.Jugador;
import com.example.C34S.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class jugadorController {

@Autowired
    JugadorService jugadorService;


    @GetMapping("/getJugador/{nombre}")
    public ResponseEntity<Jugador> buscarOdontologo(@PathVariable String nombre){
        ResponseEntity<Jugador> response;

        System.out.println(nombre);
        System.out.println("name: "+jugadorService.buscarPorNombre(nombre));

        if (jugadorService.buscarPorNombre(nombre)!=null){
            response = ResponseEntity.ok(jugadorService.buscarPorNombre(nombre)) ;
        }else
        {
            response = ResponseEntity.status(418).build();
        }
        return response;
    }

    @PostMapping("/jugador/nuevo")
    public ResponseEntity<Jugador> nuevoOdontologo(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.guardar(jugador)) ;
    }








}
