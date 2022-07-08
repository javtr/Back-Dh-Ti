package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Domicilio;
import com.example.integradornuevo.repository.IDomicilioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    private IDomicilioRepository iDomicilioRepository;

    public DomicilioService(IDomicilioRepository iDomicilioRepository) {
        this.iDomicilioRepository = iDomicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        return iDomicilioRepository.save(d);
    }

    public Domicilio buscar(Integer id){
        Domicilio domicilio = null;
        Optional<Domicilio> optionalDomicilio = iDomicilioRepository.findById(id);
        if (optionalDomicilio.isPresent()){
            domicilio = optionalDomicilio.get();
        }
        return domicilio;
    }

    public List<Domicilio> buscarTodos(){
        return iDomicilioRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if (this.buscar(id)==null){
            throw new ResourceNotFoundException("No existe un domicilio con el ID: " + id);
        } else {
            iDomicilioRepository.deleteById(id);
        }

    }

    public Domicilio actualizar(Domicilio d) {
        return iDomicilioRepository.save(d);
    }

}