package br.com.fiap.service;

import br.com.fiap.controller.dto.UsuarioDTO;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.models.Usuario;
import br.com.fiap.strategies.usuario.UsuarioStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioStrategy usuarioStrategies;

    @Autowired
    public void setUsuarioStrategy(UsuarioStrategy usuarioStrategy) {
        this.usuarioStrategies = usuarioStrategy;
    }

    public List<Usuario> listaOrganizadaUsuarios(UsuarioStrategy strategy) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return strategy.organizar(usuarios);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario encontrarUsuarioPorID(Long id) {
        return usuarioRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public Usuario atualizaUsuario(Long id, Usuario usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
    }

    public void atualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDTO.getId());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setSenha(usuarioDTO.getSenha());
            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + usuarioDTO.getId());
        }
    }

    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
