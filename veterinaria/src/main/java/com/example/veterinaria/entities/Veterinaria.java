package com.example.veterinaria.entities;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "veterinarias")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "veterinaria_secuencia")
    private Long id;
    private String nombre;
    private int costo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinaria_id")
    private List<Mascota> mascotas;

    public Veterinaria() {
    }

    public Veterinaria(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
