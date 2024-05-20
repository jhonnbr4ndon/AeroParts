package br.com.fiap.strategies.cotacao;

import br.com.fiap.models.Cotacao;

import java.util.List;

public interface CotacaoEstrategy {

    List<Cotacao> organizar(List<Cotacao> cotacao);

}
