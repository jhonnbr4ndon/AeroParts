package br.com.fiap.controller;

import br.com.fiap.controller.dto.UsuarioDTO;
import br.com.fiap.service.UsuarioService;
import br.com.fiap.models.Usuario;
import br.com.fiap.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public String criarUsuario(@ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return "redirect:/usuario";
    }

    @GetMapping("/novo")
    public String formularioNovoUsuario(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "usuarioForm";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios().stream()
                .map(UsuarioMapper::entityDTO)
                .collect(Collectors.toList());
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> encontrarUsuarioPorID(@PathVariable Long id) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        model.addAttribute("usuarioDTO", UsuarioMapper.entityDTO(usuario));
        return "usuarioEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        usuarioService.atualizarUsuario(usuarioDTO);
        return "redirect:/usuario";
    }

    @GetMapping("/delete/{id}")
    public String removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return "redirect:/usuario";
    }
}
