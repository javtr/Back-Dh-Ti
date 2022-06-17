package com.example.Integrador.Dao.Impl;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Models.Turno;
import com.example.Integrador.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class TurnoDaoList implements IDao<Turno> {
    private List<Turno> turnos= new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        System.out.println(turno.getFecha());
        System.out.println(Util.utilDateToSqlDate(turno.getFecha()));
        Turno turnoTemp = new Turno((turnos.size()+1),turno.getPaciente(),turno.getOdontologo(),Util.utilDateToSqlDate(turno.getFecha()));
        turnos.add(turnoTemp);
        return turnoTemp;
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
