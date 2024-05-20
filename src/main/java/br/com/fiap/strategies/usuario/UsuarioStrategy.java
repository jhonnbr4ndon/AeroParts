package br.com.fiap.strategies.usuario;

import br.com.fiap.models.Usuario;

import java.util.List;

public interface UsuarioStrategy {

    List<Usuario> organizar(List<Usuario> usuarios);

}
