package com.example.integradornuevo.service;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Domicilio;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
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
public class DomicilioServiceTest {

    @Autowired
    DomicilioService domicilioService;

    @Test
    public void agregarYBuscarDomicilioTest() {
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR DOMICILIO");
        System.out.println("==============================");
        Domicilio d = new Domicilio("Calle", "4", "Temperley", "Buenos");
        domicilioService.guardar(d);

        Domicilio domicilioD = domicilioService.buscar(1);
        assertNotNull(domicilioD);
    }

    @Test
    public void eliminarDomicilioTest() throws ResourceNotFoundException {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR DOMICILIO");
        System.out.println("==============================");

        domicilioService.eliminar(1);
        Assert.assertNull(domicilioService.buscar(1));
    }

    @Test
    public void listarTodosTest(){
        List<Domicilio> domicilios = domicilioService.buscarTodos();
        Assert.assertFalse(domicilios.isEmpty());
        Assert.assertTrue(true);
        System.out.println(domicilios);
    }

}