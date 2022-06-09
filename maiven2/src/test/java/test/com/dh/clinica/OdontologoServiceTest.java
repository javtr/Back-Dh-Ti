package test.com.dh.clinica;

import com.dh.clinina.clinica.dao.impl.OdontologoDaoH2;
import com.dh.clinina.clinica.model.Odontologo;
import com.dh.clinina.clinica.service.OdontologoService;
import org.junit.Test;

public class OdontologoServiceTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void agregarOdontologo(){
        Odontologo odontologo = new Odontologo( "matricula01", "pepe","lopez");
        Odontologo o1 = odontologoService.guardar(odontologo);
    }
}
