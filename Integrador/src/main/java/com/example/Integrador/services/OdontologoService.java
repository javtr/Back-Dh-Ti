package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Models.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoDaoH2;

    public OdontologoService(IDao<Odontologo> odontologoDaoH2) {
        this.odontologoDaoH2 = odontologoDaoH2;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoDaoH2.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoDaoH2.buscarTodos();
    }
}
