package br.com.fiap.service;

import br.com.fiap.repository.FornecedorRepository;
import br.com.fiap.controller.dto.FornecedorDTO;
import br.com.fiap.models.Fornecedor;
import br.com.fiap.strategies.fornecedor.FornecedorStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorStrategy fornecedorStrategy;

    @Autowired
    private void setFornecedorStrategy(FornecedorStrategy fornecedorStrategy) {
        this.fornecedorStrategy = fornecedorStrategy;
    }

    public List<Fornecedor> listaOrganizadaForenecedor(FornecedorStrategy strategy) {
        List<Fornecedor> fornecedors = fornecedorRepository.findAll();
        return strategy.organizar(fornecedors);
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor encontrarFornecedorPorID(Long id) {
        return fornecedorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id));
    }
    @Transactional
    public Fornecedor atualizaFornecedor(Long id, Fornecedor fornecedorDTO) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id) );
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setContato(fornecedorDTO.getContato());
        return fornecedor;
    }

   public void atualizarFornecedor(FornecedorDTO fornecedorDTO) {
       Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(fornecedorDTO.getId());
       if (optionalFornecedor.isPresent()) {
           Fornecedor fornecedor = optionalFornecedor.get();
           fornecedor.setNome(fornecedorDTO.getNome());
           fornecedor.setEndereco(fornecedorDTO.getEndereco());
           fornecedor.setContato(fornecedorDTO.getContato());
           fornecedorRepository.save(fornecedor);
       } else {
           throw new RuntimeException("Fornecedor não encontrado com o ID: " + fornecedorDTO.getId());
       }
   }

    public void removerFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
