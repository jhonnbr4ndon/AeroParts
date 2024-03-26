package br.com.fiap.controller;

import br.com.fiap.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

//    @PostMapping
//    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
//        Pedido pedido = pedidoService.criarPedido(PedidoMapper.entity(pedidoDTO));
//        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
//        List<PedidoDTO> pedidoDTO = pedidoService.listarPedido().stream().map(PedidoMapper::entityDTO).toList();
//        return ResponseEntity.ok(pedidoDTO);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PedidoDTO> encontrarPedidoPorID(@PathVariable Long id) {
//        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
//        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
//        return pedidoService.atualizarPedido(id, pedidoDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removerPedido(@PathVariable Long id) {
//        pedidoService.removerPedido(id);
//        return ResponseEntity.noContent().build();
//    }
}
