package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JogadorJpaRepository extends JpaRepository<Jogador, Long>, JogadorJpaRepositoryCustom, PagingAndSortingRepository<Jogador, Long> {
    Jogador findById(long id);

    List<Jogador> findAll();
}
