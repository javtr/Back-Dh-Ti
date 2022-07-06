package com.dh.clinica.controller;

import com.dh.clinica.dao.impl.OdontologoDaoH2;
import com.dh.clinica.dao.settings.DataBaseSettings;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2(new DataBaseSettings()));

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo)) ;
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Odontologo> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null){
            response= ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if(odontologoService.buscar(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else{
            odontologoService.eliminar(id);
            response = ResponseEntity.status((HttpStatus.NO_CONTENT)).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        ResponseEntity<Odontologo> response;
        if(odontologoService.buscar(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else{
            response = ResponseEntity.ok(odontologoService.buscar(id));
        }
        return response;
    }

}
