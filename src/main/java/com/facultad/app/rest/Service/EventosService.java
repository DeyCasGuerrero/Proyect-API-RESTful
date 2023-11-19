package com.facultad.app.rest.Service;

import com.facultad.app.rest.Model.Eventos;
import com.facultad.app.rest.Model.Noticias;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventosService {
    public List<Eventos> obtenerTodo();
    public Eventos guardar(Eventos eventos);
    public Eventos obtenerPorID(long id);
    public void eliminar(long id);
}
