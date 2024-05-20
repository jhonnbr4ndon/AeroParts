package br.com.fiap.controller;

import br.com.fiap.controller.dto.CotacaoDTO;
import br.com.fiap.models.Cotacao;
import br.com.fiap.service.CotacaoService;
import br.com.fiap.service.mapper.CotacaoMapper;
import br.com.fiap.strategies.cotacao.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    //STRATEGIES COTAÇÃO

    @GetMapping("/data-recente")
    public ResponseEntity<List<CotacaoDTO>> listarCotacaoPorDataRecente() {
        CotacaoEstrategy strategy = new DataRecenteCotacao();
        List<CotacaoDTO> listarData = cotacaoService.listaOrganizadaCotacao(strategy).stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarData);
    }

    @GetMapping("/data-antiga")
    public ResponseEntity<List<CotacaoDTO>> listarCotacaoPorDataAntiga() {
        CotacaoEstrategy strategy = new DataAntigaCotacao();
        List<CotacaoDTO> listarData = cotacaoService.listaOrganizadaCotacao(strategy).stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarData);
    }

    @GetMapping("/preco-menor")
    public ResponseEntity<List<CotacaoDTO>> listarCotacaoPorPrecoMenor() {
        CotacaoEstrategy strategy = new PrecoMenorCotacao();
        List<CotacaoDTO> listarPreco = cotacaoService.listaOrganizadaCotacao(strategy).stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarPreco);
    }

    @GetMapping("/preco-maior")
    public ResponseEntity<List<CotacaoDTO>> listarCotacaoPorPrecoMaior() {
        CotacaoEstrategy strategy = new PrecoMaiorCotacao();
        List<CotacaoDTO> listarPreco = cotacaoService.listaOrganizadaCotacao(strategy).stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarPreco);
    }

    //CRUD COTAÇÃO

    @GetMapping("/lista")
    public ResponseEntity<List<CotacaoDTO>> listaCotacao() {
        List<CotacaoDTO> cotacaoDTO = cotacaoService.listarCotacoes().stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(cotacaoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CotacaoDTO> encontrarCotacaoPorID(@PathVariable Long id) {
        Cotacao cotacao = cotacaoService.encontrarCotacaoPorID(id);
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @PostMapping("/criar")
    public ResponseEntity<CotacaoDTO> criarNovaCotacao(@Valid @RequestBody CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoService.criarCotacao(CotacaoMapper.entity(cotacaoDTO));
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CotacaoDTO> atualizarCotacao(@PathVariable Long id, @Valid @RequestBody CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoService.atualizaCotacao(id, CotacaoMapper.entity(cotacaoDTO));
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCotacao(@PathVariable Long id) {
        cotacaoService.removerCotacao(id);
        return ResponseEntity.noContent().build();
    }
}
