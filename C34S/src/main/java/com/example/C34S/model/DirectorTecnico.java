package com.example.C34S.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tecnicos")
public class DirectorTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tecnico_secuencia")
    private Long id;
    private String nombre;
    private Integer edad;

    //Relacion 1 a N con Jugador (UNIDIRECCIONAL)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnico_id")
    private List<Jugador> jugadores;


    public DirectorTecnico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
