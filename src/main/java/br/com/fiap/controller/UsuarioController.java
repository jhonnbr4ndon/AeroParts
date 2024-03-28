
package br.com.fiap.controller;

import br.com.fiap.controller.dto.UsuarioDTO;
import br.com.fiap.service.UsuarioService;
import br.com.fiap.models.Usuario;
import br.com.fiap.service.mapper.UsuarioMapper;
import jakarta.validation.Valid;
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

    // CRUD Completo

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {
        List<UsuarioDTO> usuarioDTO = usuarioService.listarUsuarios().stream().map(UsuarioMapper::entityDTO).toList();
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> encontrarUsuarioPorID(@PathVariable Long id) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarNovoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizaUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.atualizaUsuario(id, UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Aplicação Thymeleaf

    @PostMapping("/novo")
    public String criarUsuario(@ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return "redirect:/usuario";
    }

    @GetMapping("/novo")
    public String formularioNovoUsuario(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "/usuario/usuarioForm";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarioDTO = usuarioService.listarUsuarios().stream().map(UsuarioMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "/usuario/usuario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        model.addAttribute("usuarioDTO", UsuarioMapper.entityDTO(usuario));
        return "/usuario/usuarioEditar";
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
