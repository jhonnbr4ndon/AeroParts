package org.example.service.mapper;

import org.example.controller.dto.FornecedorDTO;
import org.example.models.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor entity(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setContato(fornecedorDTO.getContato());
        return fornecedor;
    }

    public static FornecedorDTO entityDTO(Fornecedor fornecedor) {
        FornecedorDTO fornecedorDTO = new FornecedorDTO();
        fornecedorDTO.setNome(fornecedor.getNome());
        fornecedorDTO.setEndereco(fornecedor.getEndereco());
        fornecedorDTO.setContato(fornecedor.getContato());
        return fornecedorDTO;
    }
}
