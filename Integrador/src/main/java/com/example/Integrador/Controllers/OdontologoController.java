package com.example.Integrador.Controllers;

import com.example.Integrador.Dao.Impl.OdontologoDaoH2;
import com.example.Integrador.Dao.Impl.PacienteDaoH2;
import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.services.OdontologoService;
import com.example.Integrador.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());


    @PostMapping("/odontologo/nuevo")
    public ResponseEntity<Odontologo> nuevoOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo)) ;
    }


    @GetMapping("/odontologo/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Integer id){
        ResponseEntity<Odontologo> response;

        if (odontologoService.buscar(id)!=null){
            response = ResponseEntity.ok(odontologoService.buscar(id)) ;
        }else
        {
            response = ResponseEntity.status(418).build();
        }

        return response;
    }


    @DeleteMapping("/odontologo/borrar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id){
        ResponseEntity<String> response;
        odontologoService.eliminar(id);
        if (odontologoService.buscar(id)==null) {
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("nokas");
        }
        return response;
    }






}
