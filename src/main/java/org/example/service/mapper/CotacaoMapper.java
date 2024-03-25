package org.example.service.mapper;

import org.example.controller.dto.CotacaoDTO;
import org.example.models.Cotacao;

public class CotacaoMapper {
    public static Cotacao entity(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = new Cotacao();
        cotacao.setData(cotacaoDTO.getData());
        cotacao.setPreco(cotacaoDTO.getPreco());
        return cotacao;
    }

    public static CotacaoDTO entityDTO(Cotacao cotacao) {
        CotacaoDTO cotacaoDTO = new CotacaoDTO();
        cotacaoDTO.setData(cotacao.getData());
        cotacaoDTO.setPreco(cotacao.getPreco());
        return cotacaoDTO;
    }
}
