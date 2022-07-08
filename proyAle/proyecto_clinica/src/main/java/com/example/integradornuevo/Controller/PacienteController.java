package com.example.integradornuevo.Controller;
import com.example.integradornuevo.exceptions.ResourceNotFoundException;
import com.example.integradornuevo.model.Paciente;
import com.example.integradornuevo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    //Se inyecta la dependencia
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente p){
        return ResponseEntity.ok(pacienteService.guardar(p)) ;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Integer id){
        ResponseEntity<Paciente> response;

        if (pacienteService.buscar(id)!=null){
            response = ResponseEntity.ok(pacienteService.buscar(id));
        }else{
            response = ResponseEntity.status(404).build();
        }

        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente p){
        ResponseEntity<Paciente> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (p.getId() != null && pacienteService.buscar(p.getId()) != null){
            response= ResponseEntity.ok(pacienteService.actualizar(p));
           // response= ResponseEntity.accepted().build();
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response;
        pacienteService.eliminar(id);
        response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

}
