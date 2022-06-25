package com.example.veterinaria.repository;

import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.entities.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVeterinariaRepository extends JpaRepository<Veterinaria, Long> {

    //1- Un método que cree una nueva Veterinaria. No es necesario puedo usar save()

    //2- Un método para agregar mascotas a la Veterinaria. NO es necesario puedo usar veterinaria.getMascotas().add(mascota)

    //3- Un método para consultar todas las mascotas de una Veterinaria. No es necesario puedo usar veterinaria.getMascotas()

    //4- Un método para consultar todas las mascotas que son perro.
    @Query("SELECT m FROM Mascota m where m.tipo = ?1 ")
    List<Mascota> findAllPerros(String tipo);
}
