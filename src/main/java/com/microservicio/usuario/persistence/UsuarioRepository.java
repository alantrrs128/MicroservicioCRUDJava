package com.microservicio.usuario.persistence;

import com.microservicio.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("UPDATE usuarios u SET u.nombre = :nombre, u.apellido = :apellido, u.email = :email WHERE u.id = :id")
    void update(Long id, String nombre, String apellido, String email);
}
