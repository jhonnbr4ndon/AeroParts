package org.example.service;

import org.example.controller.dto.ItemPedidoDTO;
import org.example.models.ItemPedido;
import org.example.repository.ItemPedidoRepository;
import org.example.service.mapper.ItemPedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public List<ItemPedido> listarItemPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido encontrarItemPedidoPorID(Long id) {
        return itemPedidoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ItemPedido não encontrado com o ID: " + id));
    }

    public ResponseEntity<ItemPedidoDTO> atualizarItemPedido(Long id, ItemPedidoDTO itemPedidoDTO) {
        Optional<ItemPedido> optionalItemPedido = itemPedidoRepository.findById(id);
        if (optionalItemPedido.isPresent()) {
            ItemPedido itemPedido = optionalItemPedido.get();
            itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
            ItemPedido atualizarItemPedido = itemPedidoRepository.save(itemPedido);
            return ResponseEntity.ok(ItemPedidoMapper.entityDTO(atualizarItemPedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void removerItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
