package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Models.Turno;

import java.util.List;

public class TurnoService {

    private IDao<Turno> turnoDaoH2;

    //Constructor
    public TurnoService(IDao<Turno> turnoRepository) {
        this.turnoDaoH2 = turnoRepository;
    }


    public List<Turno> buscarTodos(){
        return turnoDaoH2.buscarTodos();
    }

    public Turno buscar(Integer id){
        return turnoDaoH2.buscar(id);
    }

    public Turno registrarTurno(Turno turno){
        return turnoDaoH2.guardar(turno);
    }




}
