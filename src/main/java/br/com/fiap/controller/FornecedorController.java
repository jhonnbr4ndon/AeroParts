package br.com.fiap.controller;

import br.com.fiap.controller.dto.FornecedorDTO;
import br.com.fiap.models.Fornecedor;
import br.com.fiap.service.FornecedorService;
import br.com.fiap.service.mapper.FornecedorMapper;
import br.com.fiap.strategies.fornecedor.FornecedorStrategy;
import br.com.fiap.strategies.fornecedor.NomeFornecedorStrategy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    //ESTRETEGY USUARIOS

    @GetMapping("/nome-ordenado")
    public ResponseEntity<List<FornecedorDTO>> listarFornecedorPorNome() {
        FornecedorStrategy strategy = new NomeFornecedorStrategy();
        List<FornecedorDTO> listarNomes = fornecedorService.listaOrganizadaForenecedor(strategy).stream().map(FornecedorMapper::entityDTO).toList();
        return ResponseEntity.ok(listarNomes);
    }

    //CRUD FORNECEDOR

    @GetMapping("/lista")
    public ResponseEntity<List<FornecedorDTO>> listaFornecedor() {
        List<FornecedorDTO> fornecedorDTO = fornecedorService.listarFornecedores().stream().map(FornecedorMapper::entityDTO).toList();
        return ResponseEntity.ok(fornecedorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> encontrarFornecedorPorID(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.encontrarFornecedorPorID(id);
        return ResponseEntity.ok(FornecedorMapper.entityDTO(fornecedor));
    }

    @PostMapping("/criar")
    public ResponseEntity<FornecedorDTO> criarNovoFornecedor(@Valid @RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorService.criarFornecedor(FornecedorMapper.entity(fornecedorDTO));
        return ResponseEntity.ok(FornecedorMapper.entityDTO(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> atualizarFornecedor(@PathVariable Long id, @Valid @RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorService.atualizaFornecedor(id, FornecedorMapper.entity(fornecedorDTO));
        return ResponseEntity.ok(FornecedorMapper.entityDTO(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.removerFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
