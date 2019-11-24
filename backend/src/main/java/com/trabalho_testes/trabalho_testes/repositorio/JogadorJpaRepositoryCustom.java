package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.ZonedDateTime;

public interface JogadorJpaRepositoryCustom {

    Page<Jogador> lista(String nome, Long numero, Pageable pagina);

}
