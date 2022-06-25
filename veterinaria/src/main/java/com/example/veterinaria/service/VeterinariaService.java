package com.example.veterinaria.service;

import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.entities.Veterinaria;
import com.example.veterinaria.repository.IVeterinariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinariaService {

    private IVeterinariaRepository veterinariaRepository;

    @Autowired
    public VeterinariaService(IVeterinariaRepository veterinariaRepository) {
        this.veterinariaRepository = veterinariaRepository;
    }

    public List<Mascota> findAllPerros(String tipo){
        return veterinariaRepository.findAllPerros(tipo);
    }

    public Veterinaria guardar(Veterinaria veterinaria){
        return veterinariaRepository.save(veterinaria);
    }

    public List<Veterinaria> buscar(){
        return veterinariaRepository.findAll();
    }
}

