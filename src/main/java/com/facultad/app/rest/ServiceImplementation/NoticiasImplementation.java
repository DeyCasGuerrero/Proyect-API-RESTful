package com.facultad.app.rest.ServiceImplementation;
import com.facultad.app.rest.Model.Noticias;
import com.facultad.app.rest.Repository.NoticiaRepository;
import com.facultad.app.rest.Service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiasImplementation implements NoticiasService{
    @Autowired
    NoticiaRepository repository;

    @Override
    public List<Noticias> obtenerTodo(){
        return(repository.findAll());
    }

    @Override
    public Noticias guardar(Noticias noticias){return (repository.save(noticias));}

    @Override
    public Noticias obtenerPorID(long id){return(repository.findById(id).orElse(null));}

    @Override
    public  void eliminar(long id){
        repository.deleteById(id);
    }

}
