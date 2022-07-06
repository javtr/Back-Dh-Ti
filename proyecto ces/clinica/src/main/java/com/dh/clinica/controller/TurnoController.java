package com.dh.clinica.controller;

import com.dh.clinica.dao.impl.OdontologoDaoH2;
import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.dao.impl.TurnoRepository;
import com.dh.clinica.dao.settings.DataBaseSettings;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.C25S.model.Turno;

import java.util.List;


    @RestController
    @RequestMapping("/turnos")
    public class TurnoController {

        private TurnoService turnoService = new TurnoService(new TurnoRepository());
        private PacienteService pacienteService = new PacienteService((new PacienteDaoH2(new DataBaseSettings())));
        private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2(new DataBaseSettings()));

        @GetMapping
        public ResponseEntity<List<Turno>> buscarTodos() {
            return ResponseEntity.ok(turnoService.buscarTodos());
        }

        @PostMapping
        public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
            ResponseEntity<Turno> response;
            if(pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar(turno.getOdontologo().getId()) != null){
                response = ResponseEntity.ok(turnoService.guardar(turno));
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return response;
        }


        @PutMapping
        public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
            ResponseEntity<Turno> response;
            if (turno.getId() != null
                    && turnoService.buscar(turno.getOdontologo().getId()) != null
                    && turnoService.buscar(turno.getPaciente().getId()) != null) {
                response = ResponseEntity.ok(turnoService.actualizar(turno));
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return response;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar(@PathVariable Integer id) {
            ResponseEntity<String> response;
            if (turnoService.buscar(id) == null) {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                response = ResponseEntity.status((HttpStatus.NO_CONTENT)).build();
                turnoService.eliminar(id);
            }
            return response;
        }
        @GetMapping("/{id}")
        public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id){
            ResponseEntity<Turno> response;
            if(turnoService.buscar(id) == null){
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
            else{
                response = ResponseEntity.ok(turnoService.buscar(id));
            }
            return response;
        }
    }