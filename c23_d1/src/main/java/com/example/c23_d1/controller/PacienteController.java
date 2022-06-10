package com.example.c23_d1.controller;

import com.example.c23_d1.model.Paciente;
import com.example.c23_d1.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PacienteController {
    private PacienteService pacienteService = new PacienteService();

    @GetMapping("/email")
    public String buscarPacientesEmail (Model model){
        model.addAttribute("otracosa", pacienteService.buscarPorEmail("facu23c@gmail.com"));
        return "index";
    }

    @GetMapping("/lista")
    public String buscarLista(Model model){
        model.addAttribute("lista",pacienteService.buscarTodos());
        model.addAttribute("algo",pacienteService.buscarTodos());
        return "index";
    }

    @GetMapping("/algo")
    public String buscarLista2(Model model){
        model.addAttribute("algo",pacienteService.buscarTodos());
        return "index";
    }




}
