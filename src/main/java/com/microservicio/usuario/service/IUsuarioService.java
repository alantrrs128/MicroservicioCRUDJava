package com.microservicio.usuario.service;

import com.microservicio.usuario.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    void save(Usuario usuario);
    void deleteById(Long id);
    void update(Long id, String nombre, String apellido, String email);
}
