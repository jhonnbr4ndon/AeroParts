package org.example.service;

import org.example.controller.dto.PedidoDTO;
import org.example.controller.dto.ProdutoDTO;
import org.example.models.Pedido;
import org.example.models.Produto;
import org.example.repository.PedidoRepository;
import org.example.service.mapper.PedidoMapper;
import org.example.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido encontrarPedidoPorID(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    public ResponseEntity<PedidoDTO> atualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.setData(pedidoDTO.getData());
            pedido.setStatus(pedidoDTO.getStatus());
            Pedido pedidoAtualizado = pedidoRepository.save(pedido);
            return ResponseEntity.ok(PedidoMapper.entityDTO(pedidoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
