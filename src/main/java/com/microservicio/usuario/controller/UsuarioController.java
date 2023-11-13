package com.microservicio.usuario.controller;

import com.microservicio.usuario.entities.Usuario;
import com.microservicio.usuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/todos")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping("/modificar/{id}")
    public void updateUsuario(@RequestBody Usuario usuario,@PathVariable Long id) {
        usuarioService.update(id, usuario.getNombre(), usuario.getApellido(), usuario.getEmail());
    }
}
