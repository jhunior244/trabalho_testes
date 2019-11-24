package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcaoJogadorJpaRepository extends JpaRepository<AcaoJogador, Long>, AcaoJogadorJpaRepositoryCustom {
    AcaoJogador findById(long id);
}
