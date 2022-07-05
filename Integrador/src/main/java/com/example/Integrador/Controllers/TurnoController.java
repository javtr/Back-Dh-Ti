package com.example.Integrador.Controllers;
import com.example.Integrador.Models.Turno;
import com.example.Integrador.services.OdontologoService;
import com.example.Integrador.services.PacienteService;
import com.example.Integrador.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Turno>buscar(@PathVariable Integer id){
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PostMapping("nuevo")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        return response;
    }

    @GetMapping("buscarTodos")
    public ResponseEntity<List<Turno>>  buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }
}
