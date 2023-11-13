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

    /**
     * Esta clase consulta todos los usuarios que hay en la tabla Usuarios
     * @author: Alan Torres Lomeli
     * @version: 13/11/2023
     * @return Lista de usuarios encontrados
     */
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    /**
     * Esta clase consulta solo un usuario que se desea encontrar
     * @author: Alan Torres Lomeli
     * @version: 13/11/2023
     * @param id del usuario que se desea encontrar
     * @return Regresa el usuario que buscamos
     */
    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    /**
     * Guarda un nuevo usuario
     * @author: Alan Torres Lomeli
     * @version: 13/11/2023
     * @param usuario con los datos que se desea guardar
     */
    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario
     * @author: Alan Torres Lomeli
     * @version: 13/11/2023
     * @param id de usuario que se desea eliminar
     */
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Modifica un solo usuario
     * @author: Alan Torres Lomeli
     * @version: 13/11/2023
     * @param usuario con los datos que se desean modificar
     * @param id del usuario que se desea modificar
     */
    @Override
    public void update(Usuario usuario, Long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioRepository.save(user);
    }
}
