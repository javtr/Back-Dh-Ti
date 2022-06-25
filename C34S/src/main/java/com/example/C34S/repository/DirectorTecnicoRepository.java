package com.example.C34S.repository;

import com.example.C34S.model.DirectorTecnico;
import com.example.C34S.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorTecnicoRepository extends JpaRepository<DirectorTecnico,Long> {




    //1. Un método que cree un nuevo director técnico. Uso el save()

    //2. Un método para agregar jugadores al técnico.
    //DirectorTecnico.getJugadores().add(Jugador jugador);
    //save(unTecnico)




    //3. Un método para consultar todos los jugadores de un técnico.
    //unTecnico.getJugadores()

}
