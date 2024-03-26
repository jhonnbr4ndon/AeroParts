package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.ItemPedidoDTO;
import br.com.fiap.models.ItemPedido;

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
