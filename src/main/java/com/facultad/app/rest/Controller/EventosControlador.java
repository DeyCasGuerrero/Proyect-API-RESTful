package com.facultad.app.rest.Controller;

import com.facultad.app.rest.Model.Eventos;
import com.facultad.app.rest.ServiceImplementation.EventosImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@Validated
public class EventosControlador {
    private final EventosImplementation implementation;

    @Autowired
    public EventosControlador(EventosImplementation implementation) {
        this.implementation = implementation;
    }
    @GetMapping("/all")
    public List<Eventos> obtenerTodos(){return implementation.obtenerTodo();}

    @PostMapping("/guardar/eventos")
    public ResponseEntity<Eventos> guardar(@RequestBody Eventos eventos){
        Eventos nuevo_evento=implementation.guardar(eventos);
        return new ResponseEntity<>(nuevo_evento, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/eventos/{id}")
    public ResponseEntity<Eventos> actualizarEventos(@PathVariable long id, @RequestBody Eventos eventos){
        Eventos actualizarEventos=implementation.obtenerPorID(id);
        actualizarEventos.setTitulo(eventos.getTitulo());
        actualizarEventos.setContenido(eventos.getContenido());

        Eventos eventosActualizados = implementation.guardar(actualizarEventos);
        return new ResponseEntity<>(eventosActualizados, HttpStatus.CREATED);
    }

    @PatchMapping("/actualizar/imagen/{id}")
    public  ResponseEntity<Eventos> actualizarImagen(@PathVariable long id, @RequestParam("imagen")MultipartFile imagen){
        try {
            Eventos imagenEventoExiste = implementation.obtenerPorID(id);
            if (!imagen.isEmpty()){
                imagenEventoExiste.setImagen(imagen.getBytes());
            }
            Eventos imagenEvento_actualizado = implementation.guardar(imagenEventoExiste);
            return new ResponseEntity<>(imagenEvento_actualizado, HttpStatus.CREATED);
        }catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEvento(@PathVariable long id){
        this.implementation.eliminar(id);
        HashMap<String,Boolean> estadoEventos=new HashMap<>();
        estadoEventos.put("Evento eliminado", true);
        return  ResponseEntity.ok(estadoEventos);
    }
}
