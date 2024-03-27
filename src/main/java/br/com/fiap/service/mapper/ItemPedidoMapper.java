package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.ItemPedidoDTO;
import br.com.fiap.models.ItemPedido;

public class ItemPedidoMapper {

    public static ItemPedido entity(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(itemPedidoDTO.getId());
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
        return itemPedido;
    }

    public static ItemPedidoDTO entityDTO(ItemPedido itemPedido) {
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
        itemPedidoDTO.setId(itemPedido.getId());
        itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
        return itemPedidoDTO;
    }

}
