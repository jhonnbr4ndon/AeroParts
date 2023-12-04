package org.example.controller;

import org.example.models.ItemPedido;
import org.example.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obterItemPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.obterItemPedidoPorId(id).orElse(null));
    }

    @GetMapping
    public List<ItemPedido> mostrarItemPedido() {
        return itemPedidoService.mostrarItemPedido();
    }

    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return ResponseEntity.ok(itemPedidoService.salvarItemPedido(itemPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
        Optional<ItemPedido> itemPedidoExistente = itemPedidoService.obterItemPedidoPorId(id);

        if (itemPedidoExistente.isPresent()) {
            ItemPedido itemPedido = itemPedidoExistente.get();
            itemPedido.setQuantidade(itemPedidoAtualizado.getQuantidade());

            return ResponseEntity.ok(itemPedidoService.salvarItemPedido(itemPedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
    }
}
