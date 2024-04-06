package br.com.fiap.service;

import br.com.fiap.repository.ItemPedidoRepository;
import br.com.fiap.controller.dto.ItemPedidoDTO;
import br.com.fiap.models.ItemPedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public ItemPedido atualizaItemPedido(Long id, ItemPedido itemPedidoDTO) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido não encontrado com o ID: " + id));
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
        return itemPedido;
    }

    public void atualizarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        Optional<ItemPedido> optionalItemPedido = itemPedidoRepository.findById(itemPedidoDTO.getId());
        if (optionalItemPedido.isPresent()) {
            ItemPedido itemPedido = optionalItemPedido.get();
            itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
            itemPedidoRepository.save(itemPedido);
        } else {
            throw new RuntimeException("ItemPedido não encontrado com o ID: " + itemPedidoDTO.getId());
        }
    }

    public void removerItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
