package br.com.fiap.controller;

import br.com.fiap.controller.dto.PedidoDTO;
import br.com.fiap.models.Pedido;
import br.com.fiap.service.PedidoService;
import br.com.fiap.service.mapper.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novo")
    public String criarPedido(@ModelAttribute PedidoDTO pedidoDTO) {
        pedidoService.criarPedido(PedidoMapper.entity(pedidoDTO));
        return "redirect:/pedido";
    }

    @GetMapping("/novo")
    public String formularioNovoPedido(Model model) {
        model.addAttribute("pedidoDTO", new PedidoDTO());
        return "/pedido/pedidoForm";
    }

    @GetMapping
    public String listarPedidos(Model model) {
        List<PedidoDTO> pedidoDTO = pedidoService.listarPedido().stream().map(PedidoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("pedidoDTO", pedidoDTO);
        return "/pedido/pedido";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> encontrarPedidoPorID(@PathVariable Long id) {
        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
        model.addAttribute("pedidoDTO", PedidoMapper.entityDTO(pedido));
        return "/pedido/pedidoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarPedido(@PathVariable Long id, @ModelAttribute PedidoDTO pedidoDTO) {
        pedidoDTO.setId(id);
        pedidoService.atualizarPedidos(pedidoDTO);
        return "redirect:/pedido";
    }

    @GetMapping("/delete/{id}")
    public String removerPedido(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return "redirect:/pedido";
    }
}
