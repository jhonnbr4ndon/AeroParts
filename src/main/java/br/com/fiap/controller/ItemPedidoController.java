package br.com.fiap.controller;

import br.com.fiap.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

//    @PostMapping
//    public ResponseEntity<ItemPedidoDTO> criarItemPedido(@RequestBody ItemPedidoDTO itemPedidoDTO) {
//        ItemPedido itemPedido = itemPedidoService.criarItemPedido(ItemPedidoMapper.entity(itemPedidoDTO));
//        return ResponseEntity.ok(ItemPedidoMapper.entityDTO(itemPedido));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ItemPedidoDTO>> listarItemPedidos() {
//        List<ItemPedidoDTO> itemPedidoDTO = itemPedidoService.listarItemPedido().stream().map(ItemPedidoMapper::entityDTO).toList();
//        return ResponseEntity.ok(itemPedidoDTO);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ItemPedidoDTO> encontrarItemPedidoPorID(@PathVariable Long id) {
//        ItemPedido itemPedido = itemPedidoService.encontrarItemPedidoPorID(id);
//        return ResponseEntity.ok(ItemPedidoMapper.entityDTO(itemPedido));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ItemPedidoDTO> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedidoDTO itemPedidoDTO) {
//        return itemPedidoService.atualizarItemPedido(id, itemPedidoDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removerItemPedido(@PathVariable Long id) {
//        itemPedidoService.removerItemPedido(id);
//        return ResponseEntity.noContent().build();
//    }
}
