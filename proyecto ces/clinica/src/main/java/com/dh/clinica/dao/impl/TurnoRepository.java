package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.IDao;
import com.example.C25S.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoRepository implements IDao<Turno> {

    private List<Turno> turnos= new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
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
        Turno turno = buscar(id);
        if (buscar(id)!=null){
            turnos.remove(turno);
        }
    }

    //corroborar
    @Override
    public List<Turno> buscarTodos() {
//        List<Turno> turnos = null;
//        for (Turno turno : turnos){
//            turnos.add(turno);
//        }
        return turnos;
    }
    //corroborar
    @Override
    public Turno actualizar(Turno turno) {
        int index = -1;
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getId().equals(turno.getId())) {
                index = i;
            }
        }
        turnos.set(index, turno);
        return turno;
    }

//        for (Turno turnoX : turnos) {
//            if (turno.getId().equals(turnoX.getId())) {
//                turnoX = turno;
//                return turnoX;
//            }
//        }
//        return null;
//    }
}
