package com.facultad.app.rest.Repository;

import com.facultad.app.rest.Model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {
}
