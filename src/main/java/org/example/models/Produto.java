package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;
    @Column(name = "produto_nome")
    private String nome;
    @Column(name = "produto_descricao")
    private String descricao;
    @Column(name = "produto_preco")
    private Double preco;

    @JsonIgnore
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    private List<ItemPedido> itemPedidos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

}
