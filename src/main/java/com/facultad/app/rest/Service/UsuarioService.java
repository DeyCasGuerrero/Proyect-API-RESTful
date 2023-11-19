package com.facultad.app.rest.Service;

import com.facultad.app.rest.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> obtenerTodo();
    public Usuario guardar(Usuario usuario);
    public Usuario obtenerPorID(long id);
    public Usuario obtenerPorTelefono (int telefono); //Implemetación a futuro
    public Usuario obtenerPorEmail(String correo); //Implemetación a futuro
    public Usuario obtenerPorNombre(String nombre); //Implemetación a futuro
    public void eliminar(long id);

}
