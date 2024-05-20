package br.com.fiap.strategies.cotacao;

import br.com.fiap.models.Cotacao;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrecoMaiorCotacao implements CotacaoEstrategy {

    @Override
    public List<Cotacao> organizar(List<Cotacao> cotacao) {
        return cotacao.stream()
                .sorted(Comparator.comparing(Cotacao::getPreco).reversed())
                .collect(Collectors.toList());
    }
}
