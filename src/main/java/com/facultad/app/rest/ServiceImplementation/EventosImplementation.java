package com.facultad.app.rest.ServiceImplementation;

import com.facultad.app.rest.Model.Eventos;
import com.facultad.app.rest.Model.Noticias;
import com.facultad.app.rest.Repository.EventosRepository;
import com.facultad.app.rest.Service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventosImplementation implements EventosService {
    @Autowired
    EventosRepository repository;


    @Override
    public List<Eventos> obtenerTodo() {
        return (repository.findAll());
    }

    @Override
    public Eventos guardar(Eventos eventos) {
        return (repository.save(eventos));
    }

    @Override
    public Eventos obtenerPorID(long id) {
        return (repository.findById(id).orElse(null));
    }

    @Override
    public void eliminar(long id) {
        repository.deleteById(id);

    }
}
