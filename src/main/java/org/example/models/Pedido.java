package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;
    @Column(name = "pedido_data")
    private Date data;
    @Column(name = "pedido_status")
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", orphanRemoval = true)
    private  List<ItemPedido> itemPedidos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cotacao_id")
    private Cotacao cotacao;
}
