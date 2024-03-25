package org.example.service;

import org.example.controller.dto.CotacaoDTO;
import org.example.models.Cotacao;
import org.example.repository.CotacaoRepository;
import org.example.service.mapper.CotacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public Cotacao criarCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    public List<Cotacao> listarCotacoes() {
        return cotacaoRepository.findAll();
    }

    public Cotacao encontrarCotacaoPorID(Long id) {
        return cotacaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cotação não encontrado com o ID: " + id));
    }

    public ResponseEntity<CotacaoDTO> atualizarCotacao(Long id, CotacaoDTO cotacaoDTO) {
        Optional<Cotacao> optionalCotacao = cotacaoRepository.findById(id);
        if (optionalCotacao.isPresent()) {
            Cotacao cotacao = optionalCotacao.get();
            cotacao.setData(cotacaoDTO.getData());
            cotacao.setPreco(cotacaoDTO.getPreco());
            Cotacao cotacaoAtualizado = cotacaoRepository.save(cotacao);
            return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacaoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public void removerCotacao(Long id) {
        cotacaoRepository.deleteById(id);
    }
}
