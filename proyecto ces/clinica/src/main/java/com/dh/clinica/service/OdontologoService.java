package com.dh.clinica.service;


import com.dh.clinica.dao.IDao;
import com.dh.clinica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar (Odontologo o){
        odontologoDao.guardar(o);
        return o;
    }

    public Odontologo buscar(Integer id){
        return odontologoDao.buscar(id);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoDao.buscarTodos();
    }

    public void eliminar(Integer id){
        odontologoDao.eliminar(id);
    }
    public Odontologo actualizar(Odontologo o){
        return odontologoDao.actualizar(o);
    }
}
