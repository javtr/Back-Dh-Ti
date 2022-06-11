package com.example.c23_d1.service;

import com.example.c23_d1.model.Odontologo;
import com.example.c23_d1.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteService {

    private List<Paciente> pacientes = new ArrayList();

    public PacienteService() {
        Odontologo odontologo1 = new Odontologo(12, "moreno", "andrea", "asd32");
        Odontologo odontologo2 = new Odontologo(13, "romero", "camila", "as432");
        Paciente paciente1 = new Paciente(1,"torres", "carlos","carlos@gmail.com", 13, "29.03.22",odontologo1);
        Paciente paciente2 = new Paciente(2,"torres", "carlos","facu23c@gmail.com", 25, "29.03.22",odontologo2);

        pacientes.add(paciente1);
        pacientes.add(paciente2);
    }

    public List buscarTodos(){
        return pacientes;
    }

    public Paciente buscarPorEmail(String email){
        Paciente pacienteRet = null;
        for (Paciente p:pacientes) {
            if (p.getEmail().equals(email)){
                pacienteRet = p;
            }
        }
        return pacienteRet;
    }


    public Paciente buscarPorDni(int dni){
        Paciente pacienteRet = null;
        for (Paciente p:pacientes) {
            if (p.getDni().equals(dni)){
                pacienteRet = p;
            }
        }
        return pacienteRet;
    }




}

