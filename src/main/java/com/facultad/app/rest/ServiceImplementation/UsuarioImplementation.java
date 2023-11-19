package com.facultad.app.rest.ServiceImplementation;

import com.facultad.app.rest.Model.Usuario;
import com.facultad.app.rest.Repository.UsuarioRepository;
import com.facultad.app.rest.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImplementation implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> obtenerTodo() {
        return (repository.findAll());
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return (repository.save(usuario));
    }

    @Override
    public Usuario obtenerPorID(long id) {
        return (repository.findById(id).orElse(null));
    }

    @Override
    public Usuario obtenerPorTelefono(int telefono) {
        return (repository.findByTelefono(telefono));
    }

    @Override
    public Usuario obtenerPorEmail(String correo) {
        return (repository.findByCorreo(correo));
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        return (repository.findByNombre(nombre));
    }

    @Override
    public void eliminar(long id) {
        repository.deleteById(id);

    }



}
