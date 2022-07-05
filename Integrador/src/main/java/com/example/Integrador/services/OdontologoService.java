package com.example.Integrador.services;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Dao.Impl.OdontologoRepository;
import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.Models.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {

        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Odontologo buscar(Integer id){
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo = odontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()){
            odontologo = optionalOdontologo.get();
        }
        return odontologo;
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }
}
