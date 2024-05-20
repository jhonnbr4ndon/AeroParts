package br.com.fiap.strategies.produto;

import br.com.fiap.models.Produto;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrecoMaiorStrategy implements ProdutoStrategy {
    @Override
    public List<Produto> organizar(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .collect(Collectors.toList());
    }
}
