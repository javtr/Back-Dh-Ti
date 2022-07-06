package com.example.Integrador.services;
import com.example.Integrador.Dao.Impl.TurnoRepository;
import com.example.Integrador.Models.Turno;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;

    //Constructor
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        //return turnoDaoH2.buscarTodos();
        return turnoRepository.findAll();
    }

    public Turno buscar(Integer id){
        //return turnoDaoH2.buscar(id);
        //return turnoRepository.findById(id).get();

            Turno turno = null;
            Optional<Turno> optionalTurno = turnoRepository.findById(id);
            if (optionalTurno.isPresent()){
                turno = optionalTurno.get();
            }

            return turno;
    }


    public Turno registrarTurno(Turno turno){
        //return turnoDaoH2.guardar(turno);
        return turnoRepository.save(turno);
    }
}
