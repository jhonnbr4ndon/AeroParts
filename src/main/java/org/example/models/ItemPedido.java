package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "itemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_quantidade")
    private Integer quantidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
