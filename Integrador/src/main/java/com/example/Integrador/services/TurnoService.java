package com.example.Integrador.services;
import com.example.Integrador.Dao.Impl.TurnoRepository;
import com.example.Integrador.Models.Turno;
import com.example.Integrador.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;



    //Constructor
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public Turno buscar(Integer id){

            Turno turno = null;
            Optional<Turno> optionalTurno = turnoRepository.findById(id);
            if (optionalTurno.isPresent()){
                turno = optionalTurno.get();
            }
            return turno;
    }


    public Turno registrarTurno(Turno turno)throws BadRequestException {

        if (pacienteService.buscar(turno.getPaciente().getId()) == null || odontologoService.buscar(turno.getOdontologo().getId()) == null)
            throw new BadRequestException("Paciente u odontólogo no existe");
        return turnoRepository.save(turno);

    }


    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }




}
