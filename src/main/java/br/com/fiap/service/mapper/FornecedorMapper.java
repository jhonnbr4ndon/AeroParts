package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.FornecedorDTO;
import br.com.fiap.models.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor entity(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setContato(fornecedorDTO.getContato());
        return fornecedor;
    }

    public static FornecedorDTO entityDTO(Fornecedor fornecedor) {
        FornecedorDTO fornecedorDTO = new FornecedorDTO();
        fornecedorDTO.setId(fornecedor.getId());
        fornecedorDTO.setNome(fornecedor.getNome());
        fornecedorDTO.setEndereco(fornecedor.getEndereco());
        fornecedorDTO.setContato(fornecedor.getContato());
        return fornecedorDTO;
    }
}
