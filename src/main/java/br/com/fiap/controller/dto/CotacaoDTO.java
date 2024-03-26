package br.com.fiap.controller.dto;

import java.sql.Date;

public class CotacaoDTO {

    private Date data;
    private Double preco;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
