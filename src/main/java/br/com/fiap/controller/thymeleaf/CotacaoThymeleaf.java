package br.com.fiap.controller.thymeleaf;

import br.com.fiap.controller.dto.CotacaoDTO;
import br.com.fiap.models.Cotacao;
import br.com.fiap.service.CotacaoService;
import br.com.fiap.service.mapper.CotacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cotacao")
public class CotacaoThymeleaf {

    @Autowired
    private CotacaoService cotacaoService;

    @PostMapping("/novo")
    public String criarCotacao(@ModelAttribute CotacaoDTO cotacaoDTO) {
        cotacaoService.criarCotacao(CotacaoMapper.entity(cotacaoDTO));
        return "redirect:/cotacao";
    }

    @GetMapping("/novo")
    public String formularioNovoCotacao(Model model) {
        model.addAttribute("cotacaoDTO", new CotacaoDTO());
        return "/cotacao/cotacaoForm";
    }

    @GetMapping
    public String listarCotacao(Model model) {
        List<CotacaoDTO> cotacaoDTO = cotacaoService.listarCotacoes().stream().map(CotacaoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("cotacaoDTO", cotacaoDTO);
        return "/cotacao/cotacao";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCotacao(@PathVariable Long id, Model model) {
        Cotacao cotacao = cotacaoService.encontrarCotacaoPorID(id);
        model.addAttribute("cotacaoDTO", CotacaoMapper.entityDTO(cotacao));
        return "/cotacao/cotacaoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarCotacao(@PathVariable Long id, @ModelAttribute CotacaoDTO cotacaoDTO) {
        cotacaoDTO.setId(id);
        cotacaoService.atualizarCotacao(cotacaoDTO);
        return "redirect:/cotacao";
    }

    @GetMapping("/delete/{id}")
    public String removerCotacao(@PathVariable Long id) {
        cotacaoService.removerCotacao(id);
        return "redirect:/cotacao";
    }
}
