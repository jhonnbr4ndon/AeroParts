package org.example.service;

import org.example.models.Pedido;
import org.example.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pedido> obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> mostrarPedido() {
        return pedidoRepository.findAll();
    }
    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
