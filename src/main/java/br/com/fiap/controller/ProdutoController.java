package br.com.fiap.controller;

import br.com.fiap.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

//    @PostMapping
//    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
//        Produto produto = produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
//        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
//        List<ProdutoDTO> produtoDTO = produtoService.listarProdutos().stream().map(ProdutoMapper::entityDTO).toList();
//        return ResponseEntity.ok(produtoDTO);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProdutoDTO> encontrarProdutoPorID(@PathVariable Long id) {
//        Produto produto = produtoService.encontrarProdutoPorID(id);
//        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
//        return produtoService.atualizarProduto(id, produtoDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removerProduto(@PathVariable Long id) {
//        produtoService.removerProduto(id);
//        return ResponseEntity.noContent().build();
//    }
}
