package com.example.Integrador.Controllers;

import com.example.Integrador.Dao.Impl.OdontologoDaoH2;
import com.example.Integrador.Dao.Impl.PacienteDaoH2;
import com.example.Integrador.Dao.Impl.TurnoDaoList;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.Models.Turno;
import com.example.Integrador.services.OdontologoService;
import com.example.Integrador.services.PacienteService;
import com.example.Integrador.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("turno/")
public class TurnoController {

    private TurnoService turnoService= new TurnoService(new TurnoDaoList());
    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());
    //private PacienteService pacienteService= new PacienteService(new PacienteDaoH2());
    @Autowired
    private PacienteService pacienteService;


    @GetMapping("buscar/{id}")

    public ResponseEntity<Turno>buscar(@PathVariable Integer id){
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PostMapping("nuevo")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> response;

        if(odontologoService.buscar(turno.getOdontologo().getId()) != null && pacienteService.buscar(turno.getPaciente().getId()) != null) {
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        }else{
            response= ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

}
