package com.example.Integrador.Controllers;
import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.exceptions.ResourceNotFoundException;
import com.example.Integrador.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologo/")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/nuevo")
    public ResponseEntity<Odontologo> nuevoOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo (@PathVariable Integer id) throws ResourceNotFoundException{
        ResponseEntity<Odontologo> response;

        if (odontologoService.buscar(id)!=null){
            response = ResponseEntity.ok(odontologoService.buscar(id)) ;
        }else
        {
            throw new ResourceNotFoundException("no se encuentra odontologo: ");
        }

        return response;
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id){
        ResponseEntity<String> response;

        odontologoService.eliminar(id);

        if (odontologoService.buscar(id)==null) {
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Odontologo no fue eliminado");
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo)) ;
    }

    @GetMapping("/todos")
    public List<Odontologo> obtenerTodos(){
        return odontologoService.buscarTodos();
    }
}
