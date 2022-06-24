package com.example.C34S.service;

import com.example.C34S.model.DirectorTecnico;
import com.example.C34S.model.Jugador;
import com.example.C34S.repository.DirectorTecnicoRepository;
import com.example.C34S.repository.JugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    private DirectorTecnicoRepository tecnicoRepository;

    public TecnicoService(DirectorTecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public DirectorTecnico guardar(DirectorTecnico directorTecnico){
        return tecnicoRepository.save(directorTecnico);
    }




}
