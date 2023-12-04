package org.example.controller;

import org.example.models.Usuario;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obterUsuarioPorId(id).orElse(null));
    }

    @GetMapping
    public List<Usuario> mostrarUsuarios() {
        return usuarioService.mostrarUsuario();
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioService.obterUsuarioPorId(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());

            return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
