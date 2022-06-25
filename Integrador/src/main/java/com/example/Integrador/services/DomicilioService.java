package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.DomicioRepository;
import com.example.Integrador.Models.Domicilio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    //private IDao<Domicilio> domicilioDao;

    private DomicioRepository domicioRepository;


    public DomicilioService(DomicioRepository domicioRepository) {
        this.domicioRepository = domicioRepository;
    }

    /*

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    */


    public Domicilio guardar(Domicilio d){
        domicioRepository.save(d);
        //domicilioDao.guardar(d);
        return d;
    }
    public Domicilio buscar(Integer id){
        return domicioRepository.findById(id).get();
        //return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicioRepository.findAll();
        //return domicilioDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicioRepository.deleteById(id);
        //domicilioDao.eliminar(id);
    }

}
