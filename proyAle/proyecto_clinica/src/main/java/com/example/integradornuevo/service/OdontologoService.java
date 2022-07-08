package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Odontologo;
import com.example.integradornuevo.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private IOdontologoRepository iOdontologoRepository;

    public OdontologoService(IOdontologoRepository iOdontologoRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
    }

    public Odontologo guardar(Odontologo o){
        return iOdontologoRepository.save(o);
    }

    public Odontologo buscar(Integer id){
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo = iOdontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()){
            odontologo = optionalOdontologo.get();
        }
        return odontologo;
    }

    public List<Odontologo> buscarTodos() {
        return iOdontologoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if (this.buscar(id)==null){
            throw  new ResourceNotFoundException("No existe un odontologo con el ID: " + id);
        } else {
            iOdontologoRepository.deleteById(id);
        }

    }

    public Odontologo actualizar(Odontologo o) {
        return iOdontologoRepository.save(o);
    }

}
