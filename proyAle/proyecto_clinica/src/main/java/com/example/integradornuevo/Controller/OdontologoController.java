package com.example.integradornuevo.Controller;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Odontologo;
import com.example.integradornuevo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Integer id){
        Odontologo odontologo = odontologoService.buscar(id);
        if(odontologo !=null){
            return ResponseEntity.ok(odontologo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity<Odontologo> response;
        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null){
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.ok().body("Eliminado");
    }

}
