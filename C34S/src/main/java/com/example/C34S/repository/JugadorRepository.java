package com.example.C34S.repository;

import com.example.C34S.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JugadorRepository extends JpaRepository<Jugador,Long> {

    //1. Un método para crear un nuevo jugador. No es necesario, puedo usar: save()


    //2. Una consulta para obtener todos los jugadores. No es necesario, puedo usar: findAll()


    //3. Una consulta para obtener un jugador por nombre.
    //Es necesario crear este metodo
    @Query("SELECT j FROM Jugador j WHERE j.nombre = ?1")
    Jugador findByNombre(String nombre);

}
