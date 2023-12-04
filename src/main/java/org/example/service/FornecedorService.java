package org.example.service;

import org.example.models.Fornecedor;
import org.example.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Optional<Fornecedor> obterFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public List<Fornecedor> mostrarFornecedor() {
        return fornecedorRepository.findAll();
    }
    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
