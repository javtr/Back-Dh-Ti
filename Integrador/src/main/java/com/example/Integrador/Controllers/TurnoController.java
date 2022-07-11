package com.example.Integrador.Controllers;
import com.example.Integrador.Models.Turno;
import com.example.Integrador.exceptions.BadRequestException;
import com.example.Integrador.exceptions.ResourceNotFoundException;
import com.example.Integrador.services.OdontologoService;
import com.example.Integrador.services.PacienteService;
import com.example.Integrador.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("turno/")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Turno>buscar(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PostMapping("nuevo")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno)throws BadRequestException {
        ResponseEntity<Turno> response;
        response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        return response;
    }

    @GetMapping("buscarTodos")
    public ResponseEntity<List<Turno>>  buscarTodos(){

        return ResponseEntity.ok(turnoService.buscarTodos());
    }



    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id)throws ResourceNotFoundException {
        ResponseEntity<String> response;

        if (turnoService.buscar(id)!=null) {
            turnoService.eliminar(id);
        }else {
            throw new ResourceNotFoundException("el turno no existe: ");
        }

        if (turnoService.buscar(id)==null) {
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else {
            throw new ResourceNotFoundException("no se elimino el  turno: ");
        }
        return response;
    }

    

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }







}
