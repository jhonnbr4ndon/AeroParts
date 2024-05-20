package br.com.fiap.strategies.pedido;

import br.com.fiap.models.Pedido;

import java.util.List;

public interface PedidoStrategy {

    List<Pedido> organizar(List<Pedido> pedidos);

}
