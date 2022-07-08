package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Odontologo;
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
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void agregarYBuscarOdontologoTest(){
        System.out.println("================================");
        System.out.println("TEST AGREGAR Y BUSCAR ODONTOLOGOS");
        System.out.println("================================");

        Odontologo odontologo1 = new Odontologo("ABC123", "Olga", "Peña");
        Odontologo odontologo2 = new Odontologo("DEF456", "Ramón", "Peña");
        Odontologo odontologo3 = new Odontologo("GHI789", "Rafael", "Peña");
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo3);

        Odontologo odontologoRamon = odontologoService.buscar(2);
        assertNotNull(odontologoRamon);

    }

    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR ODONTOLOGO");
        System.out.println("==============================");

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