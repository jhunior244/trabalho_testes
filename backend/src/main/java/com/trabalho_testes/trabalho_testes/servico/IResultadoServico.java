package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.ResultadoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;

public interface IResultadoServico {

    ResultadoDto cria(Acao acao);

    ResultadoDto obtem(Long id);
}
