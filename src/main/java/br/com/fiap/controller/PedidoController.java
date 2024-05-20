package br.com.fiap.controller;

import br.com.fiap.controller.dto.PedidoDTO;
import br.com.fiap.models.Pedido;
import br.com.fiap.service.PedidoService;
import br.com.fiap.service.mapper.PedidoMapper;
import br.com.fiap.strategies.pedido.DataAntigaStrategy;
import br.com.fiap.strategies.pedido.DataRecenteStrategy;
import br.com.fiap.strategies.pedido.PedidoStrategy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    //STRATEGIES PRODUTOS

    @GetMapping("/data-recente")
    public ResponseEntity<List<PedidoDTO>> listarProdutosPorDataRecente() {
        PedidoStrategy strategy = new DataRecenteStrategy();
        List<PedidoDTO> listarData = pedidoService.listaOrganizadaPedido(strategy).stream().map(PedidoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarData);
    }

    @GetMapping("/data-antiga")
    public ResponseEntity<List<PedidoDTO>> listarProdutosPorDataAntiga() {
        PedidoStrategy strategy = new DataAntigaStrategy();
        List<PedidoDTO> listarData = pedidoService.listaOrganizadaPedido(strategy).stream().map(PedidoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarData);
    }

    //CRUD PEDIDOS

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoDTO>> listaPedidos() {
        List<PedidoDTO> pedidoDTO = pedidoService.listarPedido().stream().map(PedidoMapper::entityDTO).toList();
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> encontrarPedidoPorID(@PathVariable Long id) {
        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidoDTO> criarNovoPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.criarPedido(PedidoMapper.entity(pedidoDTO));
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizaPedido(@PathVariable Long id, @Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.atualizaPedido(id, PedidoMapper.entity(pedidoDTO));
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }
}
