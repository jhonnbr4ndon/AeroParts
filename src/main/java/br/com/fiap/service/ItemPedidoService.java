package br.com.fiap.service;

import br.com.fiap.repository.ItemPedidoRepository;
import br.com.fiap.service.mapper.ItemPedidoMapper;
import br.com.fiap.controller.dto.ItemPedidoDTO;
import br.com.fiap.models.ItemPedido;
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
