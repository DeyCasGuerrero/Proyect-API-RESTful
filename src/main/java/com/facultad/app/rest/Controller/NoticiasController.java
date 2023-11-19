package com.facultad.app.rest.Controller;

import com.facultad.app.rest.Model.Noticias;
import com.facultad.app.rest.ServiceImplementation.NoticiasImplementation;
import com.facultad.app.rest.ServiceImplementation.UsuarioImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/noticias")
@Validated
public class NoticiasController {
    @Autowired
    NoticiasImplementation implementation;

    @GetMapping("/all")
    public List<Noticias> obtenerTodo(){return  implementation.obtenerTodo();}

    @PostMapping("/guardar/noticia")
    public ResponseEntity<Noticias> guardar(@RequestBody Noticias noticias){
        Noticias nueva_noticia=implementation.guardar(noticias);
        return new ResponseEntity<>(nueva_noticia, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/noticia/{id}")
    public ResponseEntity<Noticias> actualizarNoticia(@PathVariable long id, @RequestBody Noticias noticias){
        Noticias actualizarNoticias=implementation.obtenerPorID(id);
        actualizarNoticias.setTitulo(noticias.getTitulo());
        actualizarNoticias.setContenido(noticias.getContenido());
        actualizarNoticias.setLink(noticias.getLink());

        Noticias noticiasActualizadas= implementation.guardar(actualizarNoticias);
        return new ResponseEntity<>(noticiasActualizadas, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarNoticias(@PathVariable long id){
        this.implementation.eliminar(id);
        HashMap<String,Boolean> estadoNoticias=new HashMap<>();
        estadoNoticias.put("Notica Eliminada",true);
        return ResponseEntity.ok(estadoNoticias);
    }
}
