package org.example.repository;

import org.example.models.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
