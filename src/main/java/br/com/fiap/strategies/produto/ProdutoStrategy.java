package br.com.fiap.strategies.produto;


import br.com.fiap.models.Produto;

import java.util.List;

public interface ProdutoStrategy {

    List<Produto> organizar(List<Produto> produtos);

}
