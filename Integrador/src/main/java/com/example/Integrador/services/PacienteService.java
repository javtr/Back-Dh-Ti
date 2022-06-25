package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.PacienteRepository;
import com.example.Integrador.Models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PacienteService {

    //private IDao<Paciente> pacienteIDao;


    private PacienteRepository pacienteRepository;


    /*
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }
*/
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());

        return pacienteRepository.save(p);
        //return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Integer id) {
        return pacienteRepository.findById(id).get();
        //return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
        //return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
        //pacienteIDao.eliminar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
        //return pacienteIDao.actualizar(p);
    }
}
