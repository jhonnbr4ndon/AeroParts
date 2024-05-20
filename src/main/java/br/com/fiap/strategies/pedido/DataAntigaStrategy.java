package br.com.fiap.strategies.pedido;

import br.com.fiap.models.Pedido;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataAntigaStrategy implements PedidoStrategy {

    @Override
    public List<Pedido> organizar(List<Pedido> pedidos) {
        return pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getData))
                .collect(Collectors.toList());
    }
}
