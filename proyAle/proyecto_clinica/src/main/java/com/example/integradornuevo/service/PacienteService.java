package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Paciente;
import com.example.integradornuevo.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private IPacienteRepository iPacienteRepository;

    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return iPacienteRepository.save(p);
    }

    public Paciente buscar(Integer id) {

        Paciente paciente = null;
        Optional<Paciente> optionalPaciente = iPacienteRepository.findById(id);
        if (optionalPaciente.isPresent()){
            paciente = optionalPaciente.get();
        }
        return paciente;

    }

    public List<Paciente> buscarTodos() {
        return iPacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if (this.buscar(id)==null){
            throw  new ResourceNotFoundException("No existe un paciente con el ID: " + id);
        } else {
            iPacienteRepository.deleteById(id);
        }

    }

    public Paciente actualizar(Paciente p) {
        return iPacienteRepository.save(p);
    }
}