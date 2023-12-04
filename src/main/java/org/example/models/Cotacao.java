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
@Table(name = "cotacao")
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cotacao_id")
    private Long id;
    @Column(name = "cotacao_data")
    private Date data;
    @Column(name = "preco_unitario")
    private Double preco;

    @JsonIgnore
    @OneToMany(mappedBy = "cotacao", orphanRemoval = true)
    private List<Pedido> pedidos;

}
