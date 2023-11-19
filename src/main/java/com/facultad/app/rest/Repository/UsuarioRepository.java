package com.facultad.app.rest.Repository;

import com.facultad.app.rest.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre (String nombre);
    Usuario findByTelefono (int telefono);
    Usuario findByCorreo (String correo);


}
