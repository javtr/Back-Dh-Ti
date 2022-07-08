package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Domicilio;
import com.example.integradornuevo.model.Paciente;
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
import java.util.List;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    @Test
    public void agregarYBuscarPacienteTest() {
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR PACIENTE");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "4", "Temperley", "Buenos");
        Paciente p = pacienteService.guardar(new Paciente("Toma", "PereZ", "12345678", new Date(), domicilio));
        pacienteService.guardar(p);

        Paciente pacienteP = pacienteService.buscar(1);
        assertNotNull(pacienteP);
    }

    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR PACIENTE");
        System.out.println("==============================");

        pacienteService.eliminar(1);
        Assert.assertNull(pacienteService.buscar(1));
    }

    @Test
    public void listarTodosTest(){
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertFalse(pacientes.isEmpty());
        Assert.assertTrue(true);
        System.out.println(pacientes);
    }


}