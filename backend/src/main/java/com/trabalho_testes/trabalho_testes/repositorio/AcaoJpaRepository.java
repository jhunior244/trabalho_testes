package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcaoJpaRepository extends JpaRepository<Acao, Long>, AcaoJpaRepositoryCustom {
    Acao findById(long id);
}
