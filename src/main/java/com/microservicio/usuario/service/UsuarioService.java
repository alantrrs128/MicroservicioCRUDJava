package com.microservicio.usuario.service;

import com.microservicio.usuario.entities.Usuario;
import com.microservicio.usuario.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void update(Usuario usuario, Long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        usuarioRepository.save(user);
    }
}
