package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.OdontologoRepository;
import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.Models.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    //private IDao<Odontologo> odontologoDaoH2;
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {

        this.odontologoRepository = odontologoRepository;
    }

    /*
    public OdontologoService(IDao<Odontologo> odontologoDaoH2) {
        this.odontologoDaoH2 = odontologoDaoH2;
    }
    */

    public Odontologo guardar(Odontologo odontologo){
        //return odontologoDaoH2.guardar(odontologo);
        return odontologoRepository.save(odontologo);
    }

    public Odontologo buscar(Integer id) {
        //return odontologoDaoH2.buscar(id);
        return odontologoRepository.findById(id).get();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        //return odontologoDaoH2.actualizar(odontologo);
        return odontologoRepository.save(odontologo);
    }


    public void eliminar(Integer id) {
        //odontologoDaoH2.eliminar(id);
        odontologoRepository.deleteById(id);
    }


    public List<Odontologo> buscarTodos(){
        //return odontologoDaoH2.buscarTodos();
        return odontologoRepository.findAll();
    }
}
