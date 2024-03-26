package br.com.fiap.controller;

import br.com.fiap.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

//    @PostMapping
//    public ResponseEntity<FornecedorDTO> criarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
//        Fornecedor fornecedor = fornecedorService.criarFornecedor(FornecedorMapper.entity(fornecedorDTO));
//        return ResponseEntity.ok(FornecedorMapper.entityDTO(fornecedor));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<FornecedorDTO>> listarFornecedores() {
//        List<FornecedorDTO> fornecedorDTO = fornecedorService.listarFornecedores().stream().map(FornecedorMapper::entityDTO).toList();
//        return ResponseEntity.ok(fornecedorDTO);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FornecedorDTO> encontrarFornecedorPorID(@PathVariable Long id) {
//        Fornecedor fornecedor = fornecedorService.encontrarFornecedorPorID(id);
//        return ResponseEntity.ok(FornecedorMapper.entityDTO(fornecedor));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<FornecedorDTO> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO fornecedorDTO) {
//        return fornecedorService.atualizarFornecedor(id, fornecedorDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removerFornecedor(@PathVariable Long id) {
//        fornecedorService.removerFornecedor(id);
//        return ResponseEntity.noContent().build();
//    }
}
