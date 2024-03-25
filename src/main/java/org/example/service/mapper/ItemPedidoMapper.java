package org.example.service.mapper;

import org.example.controller.dto.ItemPedidoDTO;
import org.example.models.ItemPedido;

public class ItemPedidoMapper {

    public static ItemPedido entity(ItemPedidoDTO pedidoDTO) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(pedidoDTO.getQuantidade());
        return itemPedido;
    }

    public static ItemPedidoDTO entityDTO(ItemPedido itemPedido) {
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
        itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
        return itemPedidoDTO;
    }

}
