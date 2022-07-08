package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.BadRequestException;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Turno;
import com.example.integradornuevo.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private ITurnoRepository iTurnoRepository;

    public TurnoService(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    public Turno guardarTurno(Turno t) throws BadRequestException{
        if (pacienteService.buscar(t.getPaciente().getId()) == null || odontologoService.buscar(t.getOdontologo().getId()) == null)
            throw new BadRequestException("El paciente o el odontólogo no existen");
        return iTurnoRepository.save(t);
    }

    public Turno buscarTurno(Integer id) {

        Turno turno = null;
        Optional<Turno> optionalTurno = iTurnoRepository.findById(id);
        if (optionalTurno.isPresent()){
            turno = optionalTurno.get();
        }
        return turno;

    }

    public List<Turno> buscarTodos(){
        return iTurnoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if (this.buscarTurno(id)==null){
            throw new ResourceNotFoundException("No existe un turno para el ID: " + id);
        } else {
            iTurnoRepository.deleteById(id);
        }

    }

    public Turno actualizar(Turno t) {
        return iTurnoRepository.save(t);
    }
}
