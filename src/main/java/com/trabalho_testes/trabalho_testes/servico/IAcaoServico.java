package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;

public interface IAcaoServico {

    AcaoDto cria(Acao acao);

    AcaoDto obtem(Long id);
}
