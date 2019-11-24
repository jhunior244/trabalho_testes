package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;

public interface IPagamentoServico {

    PagamentoDto cria(Long idJogador,String data);

    PagamentoDto obtem(Long id);
}
