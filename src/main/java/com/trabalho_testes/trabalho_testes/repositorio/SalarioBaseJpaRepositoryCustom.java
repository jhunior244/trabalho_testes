package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.SalarioBase;

public interface SalarioBaseJpaRepositoryCustom {

    SalarioBase obtemPorJogador(Long idJogador);
}
