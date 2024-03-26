package br.com.fiap.controller;

import br.com.fiap.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

//    @PostMapping
//    public ResponseEntity<CotacaoDTO> criarCotacao(@RequestBody CotacaoDTO cotacaoDTO) {
//        Cotacao cotacao = cotacaoService.criarCotacao(CotacaoMapper.entity(cotacaoDTO));
//        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CotacaoDTO>> listarCotacao() {
//        List<CotacaoDTO> cotacaoDTO = cotacaoService.listarCotacoes().stream().map(CotacaoMapper::entityDTO).toList();
//        return ResponseEntity.ok(cotacaoDTO);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CotacaoDTO> encontrarCotacaoPorID(@PathVariable Long id) {
//        Cotacao cotacao = cotacaoService.encontrarCotacaoPorID(id);
//        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CotacaoDTO> atualizarCotacao(@PathVariable Long id, @RequestBody CotacaoDTO cotacaoDTO) {
//        return cotacaoService.atualizarCotacao(id, cotacaoDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removerCotacao(@PathVariable Long id) {
//        cotacaoService.removerCotacao(id);
//        return ResponseEntity.noContent().build();
//    }
}
