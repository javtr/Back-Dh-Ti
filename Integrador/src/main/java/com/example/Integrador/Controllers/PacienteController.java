package com.example.Integrador.Controllers;
import com.example.Integrador.Dao.Impl.PacienteDaoH2;
import com.example.Integrador.Models.Domicilio;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.exceptions.ResourceNotFoundException;
import com.example.Integrador.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PacienteController {

@Autowired
private PacienteService pacienteService;

    @GetMapping("/todos")
    public List<Paciente> obtenerTodos(){
        System.out.println("algo2");

        return pacienteService.buscarTodos();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Paciente> nuevoPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente)) ;
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response;
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null){
            response= ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id)throws ResourceNotFoundException{
        ResponseEntity<String> response;

        if (pacienteService.buscar(id)!=null) {
            pacienteService.eliminar(id);
        }else {
            throw new ResourceNotFoundException("el paciente no existe: ");
        }

        if (pacienteService.buscar(id)==null) {
            response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else {
            throw new ResourceNotFoundException("no se elimino el  paciente: ");
        }

        return response;
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        ResponseEntity<Paciente> response;

        if (pacienteService.buscar(id)!=null){
            response = ResponseEntity.ok(pacienteService.buscar(id));
        }else{
            response = ResponseEntity.status(404).build();
        }

        return response;
    }






}
