package com.facultad.app.rest.Service;

import com.facultad.app.rest.Model.Noticias;

import java.util.List;

public interface NoticiasService {
    public List<Noticias> obtenerTodo();
    public Noticias guardar(Noticias noticias);
    public Noticias obtenerPorID(long id);
    public void eliminar(long id);
}
