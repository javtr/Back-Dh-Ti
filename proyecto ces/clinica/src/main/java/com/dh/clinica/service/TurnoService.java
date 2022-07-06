package com.dh.clinica.service;

import com.dh.clinica.dao.IDao;


import com.example.C25S.model.Turno;

import java.util.Date;
import java.util.List;

public class TurnoService {
    private IDao<Turno> turnoRepository;

    //Constructor
    public TurnoService(IDao<Turno> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno turno) {

        return turnoRepository.guardar(turno);
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.buscarTodos();
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.guardar(turno);
    }

    public Turno buscar(Integer id){
        return turnoRepository.buscar(id);
    }

    public void eliminar(Integer id){
        turnoRepository.eliminar(id);
    }
    public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    }
}
