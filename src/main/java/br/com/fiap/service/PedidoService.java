package br.com.fiap.service;

import br.com.fiap.controller.dto.PedidoDTO;
import br.com.fiap.models.Pedido;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.service.mapper.PedidoMapper;
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
