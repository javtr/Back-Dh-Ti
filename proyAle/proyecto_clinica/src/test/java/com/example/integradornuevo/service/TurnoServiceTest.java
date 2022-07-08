package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.BadRequestException;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Domicilio;
import com.example.integradornuevo.model.Odontologo;
import com.example.integradornuevo.model.Paciente;
import com.example.integradornuevo.model.Turno;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TurnoServiceTest {

    @Autowired
    TurnoService turnoService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    PacienteService pacienteService;

    @Test
    public void agregarYBuscarTurnosTest() throws BadRequestException {
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR TURNOS");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo("001", "Martin", "Rodriguez"));
        Turno turno = turnoService.guardarTurno(new Turno(paciente,odontologo,new Date()));

        Assert.assertNotNull(turnoService.buscarTurno(turno.getId()));
    }

    @Test
    public void eliminarTurnoTest() throws ResourceNotFoundException {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR TURNO");
        System.out.println("==============================");

        pacienteService.eliminar(1);
        Assert.assertNull(turnoService.buscarTurno(1));
    }

//    @Test
//    public void listarTodosTest(){
//        List<Turno> turnos = turnoService.buscarTodos();
//        Assert.assertTrue(!turnos.isEmpty());
//        Assert.assertTrue(turnos.size()>0);
//        System.out.println(turnos);
//    }

}