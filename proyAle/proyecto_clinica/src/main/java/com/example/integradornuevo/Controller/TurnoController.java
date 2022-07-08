package com.example.integradornuevo.Controller;
import com.example.integradornuevo.exceptions.BadRequestException;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Turno;
import com.example.integradornuevo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping("/guardar")
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno t) throws BadRequestException {
        return ResponseEntity.ok(turnoService.guardarTurno(t));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Turno>buscarTurno(@PathVariable Integer id){
        return ResponseEntity.ok(turnoService.buscarTurno(id));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno t){
        ResponseEntity<Turno> response;
        if (t.getId() != null && turnoService.buscarTurno(t.getId()) != null){
            response= ResponseEntity.ok(turnoService.actualizar(t));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok().body("Eliminado");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
