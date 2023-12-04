package org.example.service;

import org.example.models.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> mostrarUsuario() {
        return usuarioRepository.findAll();
    }
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
