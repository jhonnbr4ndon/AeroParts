package org.example.controller;

import org.example.models.Produto;
import org.example.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.obterProdutoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Produto> mostrarUsuarios() {
        return produtoService.mostrarProduto();
    }

    @PostMapping
    public ResponseEntity<Produto> criarUsuario(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarUsuario(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoService.obterProdutoPorId(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());

            return ResponseEntity.ok(produtoService.salvarProduto(produto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
