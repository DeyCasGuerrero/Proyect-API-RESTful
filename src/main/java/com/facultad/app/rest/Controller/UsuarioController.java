package com.facultad.app.rest.Controller;

import com.facultad.app.rest.Model.Usuario;
import com.facultad.app.rest.ServiceImplementation.UsuarioImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Validated
public class UsuarioController {
    @Autowired
    UsuarioImplementation implementation;

    @GetMapping("/all")
    public List<Usuario> obtenerTodo(){ return implementation.obtenerTodo();}

    @PostMapping("/guardar/usuario")
    public ResponseEntity<Usuario> guardar (@RequestBody Usuario usuario){
        Usuario nuevo_usuario = implementation.guardar(usuario);
        return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/usuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario actualizarUsuario = implementation.obtenerPorID(id);
        actualizarUsuario.setNombre(usuario.getNombre());
        actualizarUsuario.setCorreo(usuario.getCorreo());
        actualizarUsuario.setContraseña(usuario.getContraseña());
        actualizarUsuario.setTelefono(usuario.getTelefono());
        actualizarUsuario.setImagen(usuario.getImagen());

        Usuario usuarioActualizado = implementation.guardar(actualizarUsuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{param}")
    public ResponseEntity<Usuario> obtenerCualquierCampo(@PathVariable String param) {
        Usuario obtener;

        try {

            int atributosNumericos = Integer.parseInt(param);
            obtener = implementation.obtenerPorTelefono(atributosNumericos);

        } catch (NumberFormatException e) {

            if (param.contains("@") && param.contains(".com") || param.contains(".org") || param.contains(".net")) {

                obtener = implementation.obtenerPorEmail(param);

            } else {
                obtener = implementation.obtenerPorNombre(param);
            }
        }

        if (obtener == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(obtener);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id){
        this.implementation.eliminar(id);
        HashMap<String, Boolean> estadoUsuario = new HashMap<>();
        estadoUsuario.put("Usuario eliminado", true);
        return ResponseEntity.ok(estadoUsuario);
    }


}
