package com.dh.clinica.controller;

import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.dao.settings.DataBaseSettings;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new DataBaseSettings()));


    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente)) ;
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Paciente> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null){
            response= ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if(pacienteService.buscar(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else{
            response = ResponseEntity.status((HttpStatus.NO_CONTENT)).build();
            pacienteService.eliminar(id);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        ResponseEntity<Paciente> response;
        if(pacienteService.buscar(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else{
            response = ResponseEntity.ok(pacienteService.buscar(id));
        }
        return response;
    }


}
