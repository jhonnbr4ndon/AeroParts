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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;
    @Column(name = "usuario_nome")
    private String nome;
    @Column(name = "usuario_email")
    private String email;
    @Column(name = "usuario_senha")
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Pedido> pedidos;

}
