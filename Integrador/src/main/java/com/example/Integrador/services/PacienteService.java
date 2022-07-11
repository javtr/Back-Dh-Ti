package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.PacienteRepository;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.Models.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;


    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
    }

    public Paciente buscar(Integer id) {
        Paciente paciente = null;

        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()){
            paciente = optionalPaciente.get();
        }
        return paciente;
    }


    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }




    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}
