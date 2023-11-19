package com.facultad.app.rest.Repository;

import com.facultad.app.rest.Model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticias, Long> {

}
