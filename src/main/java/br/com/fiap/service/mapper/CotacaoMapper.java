package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.CotacaoDTO;
import br.com.fiap.models.Cotacao;

public class CotacaoMapper {
    public static Cotacao entity(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = new Cotacao();
        cotacao.setId(cotacaoDTO.getId());
        cotacao.setData(cotacaoDTO.getData());
        cotacao.setPreco(cotacaoDTO.getPreco());
        return cotacao;
    }

    public static CotacaoDTO entityDTO(Cotacao cotacao) {
        CotacaoDTO cotacaoDTO = new CotacaoDTO();
        cotacaoDTO.setId(cotacao.getId());
        cotacaoDTO.setData(cotacao.getData());
        cotacaoDTO.setPreco(cotacao.getPreco());
        return cotacaoDTO;
    }
}
