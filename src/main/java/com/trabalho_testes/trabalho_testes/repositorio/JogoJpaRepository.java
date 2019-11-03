package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;
import com.trabalho_testes.trabalho_testes.entidade.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoJpaRepository extends JpaRepository<Jogo, Long>, JogoJpaRepositoryCustom {
    Jogo findById(long id);
}
