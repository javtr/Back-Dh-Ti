package com.example.Integrador.Service;

import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.exceptions.ResourceNotFoundException;
import com.example.Integrador.services.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@Transactional
public class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {

        odontologoService.eliminar(1);
        Assert.assertNull(odontologoService.buscar(1));
    }


    @Test
    public void listarTodosTest(){
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertFalse(odontologos.isEmpty());
        Assert.assertTrue(true);
        System.out.println(odontologos);
    }

}
