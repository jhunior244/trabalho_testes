package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.dto.SalarioBaseDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;

public interface ISalarioBaseServico {

    SalarioBaseDto cria(Acao acao);

    SalarioBaseDto obtem(Long id);
}
