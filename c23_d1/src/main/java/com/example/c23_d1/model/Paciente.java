package com.example.c23_d1.model;


//Paciente (ID, Apellido, Nombre, Email, DNI, Fecha ingreso)

public class Paciente {

    private Integer id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;
    private String fecha_ingreso;

    public Paciente(Integer id, String apellido, String nombre, String email, Integer dni, String fecha_ingreso) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", dni=" + dni +
                ", fecha_ingreso='" + fecha_ingreso + '\'' +
                '}';
    }
}
