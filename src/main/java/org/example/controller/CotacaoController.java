package org.example.controller;

import org.example.models.Cotacao;
import org.example.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Cotacao> obterCotacaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cotacaoService.obterCotacaoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Cotacao> mostrarCotacoes() {
        return cotacaoService.mostrarCotacoes();
    }

    @PostMapping
    public ResponseEntity<Cotacao> criarCotacao(@RequestBody Cotacao cotacao) {
        return ResponseEntity.ok(cotacaoService.salvarCotacao(cotacao));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Cotacao> atualizarCotacao(@PathVariable Long id, @RequestBody Cotacao cotacaoAtualizado) {
        Optional<Cotacao> cotacaoExistente = cotacaoService.obterCotacaoPorId(id);

        if (cotacaoExistente.isPresent()) {
            Cotacao cotacao = cotacaoExistente.get();
            cotacao.setData(cotacaoAtualizado.getData());
            cotacao.setPreco(cotacaoAtualizado.getPreco());

            return ResponseEntity.ok(cotacaoService.salvarCotacao(cotacao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarCotacao(@PathVariable Long id) {
        cotacaoService.deletarCotacao(id);
    }

}
