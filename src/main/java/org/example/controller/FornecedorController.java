package org.example.controller;

import org.example.models.Fornecedor;
import org.example.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> obterFornecedorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.obterFornecedorPorId(id).orElse(null));
    }

    @GetMapping
    public List<Fornecedor> mostrarFornecedores() {
        return fornecedorService.mostrarFornecedor();
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.salvarFornecedor(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedorAtualizado) {
        Optional<Fornecedor> fornecedoroExistente = fornecedorService.obterFornecedorPorId(id);

        if (fornecedoroExistente.isPresent()) {
            Fornecedor fornecedor = fornecedoroExistente.get();
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            fornecedor.setContato(fornecedorAtualizado.getContato());

            return ResponseEntity.ok(fornecedorService.salvarFornecedor(fornecedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
    }
}
