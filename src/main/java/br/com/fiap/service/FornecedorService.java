package br.com.fiap.service;

import br.com.fiap.repository.FornecedorRepository;
import br.com.fiap.controller.dto.FornecedorDTO;
import br.com.fiap.models.Fornecedor;
import br.com.fiap.service.mapper.FornecedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

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
