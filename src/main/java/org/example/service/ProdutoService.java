package org.example.service;

import org.example.controller.dto.ProdutoDTO;
import org.example.models.Produto;
import org.example.repository.ProdutoRepository;
import org.example.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto encontrarProdutoPorID(Long id) {
        return produtoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public ResponseEntity<ProdutoDTO> atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.getNome());
            produto.setDescricao(produtoDTO.getDescricao());
            produto.setPreco(produtoDTO.getPreco());
            Produto produtoAtualizado = produtoRepository.save(produto);
            return ResponseEntity.ok(ProdutoMapper.entityDTO(produtoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void removerProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
