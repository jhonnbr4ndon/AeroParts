package br.com.fiap.controller;

import br.com.fiap.controller.dto.ProdutoDTO;
import br.com.fiap.models.Produto;
import br.com.fiap.service.ProdutoService;
import br.com.fiap.service.mapper.ProdutoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // CRUD Completo

    @GetMapping("/lista")
    public ResponseEntity<List<ProdutoDTO>> listaProdutos() {
        List<ProdutoDTO> produtoDTO = produtoService.listarProdutos().stream().map(ProdutoMapper::entityDTO).toList();
        return ResponseEntity.ok(produtoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> encontrarProdutoPorID(@PathVariable Long id) {
        Produto produto = produtoService.encontrarProdutoPorID(id);
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutoDTO> criarNovoProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizaProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.atualizaProduto(id, ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }

    // Aplicação Thymeleaf

    @PostMapping("/novo")
    public String criarProduto(@ModelAttribute ProdutoDTO produtoDTO) {
        produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
        return "redirect:/produto";
    }

    @GetMapping("/novo")
    public String formularioNovoProduto(Model model) {
        model.addAttribute("produtoDTO", new ProdutoDTO());
        return "/produto/produtoForm";
    }

    @GetMapping
    public String listarProdutos(Model model) {
        List<ProdutoDTO> produtoDTO = produtoService.listarProdutos().stream().map(ProdutoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("produtoDTO", produtoDTO);
        return "/produto/produto";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoService.encontrarProdutoPorID(id);
        model.addAttribute("produtoDTO", ProdutoMapper.entityDTO(produto));
        return "/produto/produtoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute ProdutoDTO produtoDTO) {
        produtoDTO.setId(id);
        produtoService.atualizarProduto(produtoDTO);
        return "redirect:/produto";
    }

    @GetMapping("/delete/{id}")
    public String removerProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return "redirect:/produto";
    }
}
