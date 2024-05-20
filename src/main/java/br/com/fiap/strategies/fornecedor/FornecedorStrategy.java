package br.com.fiap.strategies.fornecedor;

import br.com.fiap.models.Fornecedor;

import java.util.List;

public interface FornecedorStrategy {

    List<Fornecedor> organizar(List<Fornecedor> fornecedors);

}
