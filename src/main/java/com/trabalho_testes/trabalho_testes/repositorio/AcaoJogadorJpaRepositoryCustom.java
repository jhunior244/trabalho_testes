package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;

import java.util.List;

public interface AcaoJogadorJpaRepositoryCustom {

    List<AcaoJogador> listaPorJogadorEMesDoAno(Long idJogador, Integer mes, Integer ano);
}
