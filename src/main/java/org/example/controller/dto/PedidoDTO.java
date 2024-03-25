package org.example.controller.dto;

import java.sql.Date;

public class PedidoDTO {

    private Date data;
    private String status;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
