package com.example.integradornuevo.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_secuencia")
    private Integer id;
    //Relaciones con otras clases
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    private Date fecha;


//    Tomar en cuenta para Turnos
//    @OneToMany(mappedBy = "odontologo")
//    @JsonIgnore
//    private Set<Turno> turnos;

    //    "El atributo mappedBy lo usamos para indicar que el atributo “carrito” del lado de la clase Item es quien " +
//            "establece la relación y el atributo JsonIgnore lo utilizamos porque —en una relación bidireccional— si " +
//            "este objeto viaja en formato JSON, podría entrar en un bucle infinito."

    public Turno() {
    }


    public Turno(Integer id, Paciente paciente, Odontologo odontologo, Date fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Turno(Paciente paciente, Odontologo odontologo, Date fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
