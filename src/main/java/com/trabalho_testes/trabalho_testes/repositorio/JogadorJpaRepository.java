package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorJpaRepository extends JpaRepository<Jogador, Long>, JogadorJpaRepositoryCustom {
    Jogador findById(long id);
}
