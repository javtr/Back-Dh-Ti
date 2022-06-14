package com.example.Integrador.Controllers;
import com.example.Integrador.Dao.Impl.PacienteDaoH2;
import com.example.Integrador.Models.Domicilio;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PacienteController {


private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping
     public Paciente registrar(){
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente paciente= new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio);
        return pacienteService.guardar(paciente);
    }

    @GetMapping("/todos")
    public List<Paciente> obtenerTodos(){
        //Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        //Paciente paciente= new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio);
        return pacienteService.buscarTodos();
    }


    @PostMapping("/nuevo")
    public Paciente nuevoPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }









}
