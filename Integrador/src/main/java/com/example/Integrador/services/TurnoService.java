package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.TurnoRepository;
import com.example.Integrador.Models.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    //private IDao<Turno> turnoDaoH2;
    private TurnoRepository turnoRepository;

    //Constructor
    /*
    public TurnoService(IDao<Turno> turnoRepository) {
        this.turnoDaoH2 = turnoRepository;
    }
*/

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        //return turnoDaoH2.buscarTodos();
        return turnoRepository.findAll();
    }

    public Turno buscar(Integer id){
        //return turnoDaoH2.buscar(id);
        return turnoRepository.findById(id).get();
    }

    public Turno registrarTurno(Turno turno){
        //return turnoDaoH2.guardar(turno);
        return turnoRepository.save(turno);
    }




}
