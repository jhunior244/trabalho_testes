package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.dto.JogoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;

public interface IJogoServico {

    JogoDto cria(Acao acao);

    JogoDto obtem(Long id);
}
