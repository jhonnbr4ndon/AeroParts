package org.example.controller;

import org.example.models.Pedido;
import org.example.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obterPedidoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Pedido> mostrarPedido() {
        return pedidoService.mostrarPedido();
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.salvarPedido(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Optional<Pedido> PedidoExistente = pedidoService.obterPedidoPorId(id);

        if (PedidoExistente.isPresent()) {
            Pedido pedido = PedidoExistente.get();
            pedido.setData(pedidoAtualizado.getData());
            pedido.setStatus(pedidoAtualizado.getStatus());

            return ResponseEntity.ok(pedidoService.salvarPedido(pedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }
}
