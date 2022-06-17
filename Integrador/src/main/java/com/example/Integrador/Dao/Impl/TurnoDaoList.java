package com.example.Integrador.Dao.Impl;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Models.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoDaoList implements IDao<Turno> {
    private List<Turno> turnos= new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        turno.setId(turnos.size()+1);
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for (Turno turno : turnos){
            if (turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Turno> buscarTodos() {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

}
