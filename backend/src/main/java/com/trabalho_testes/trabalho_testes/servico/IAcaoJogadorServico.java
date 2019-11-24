package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.dto.AcaoJogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;

import java.util.List;

public interface IAcaoJogadorServico {

    AcaoJogadorDto cria(AcaoJogadorDto acaoJogadorDto);

    AcaoJogadorDto obtem(Long id);

    List<AcaoJogadorDto> listaPorJogadorEMesDoAno(Long idJogador, Integer mes, Integer ano);
}
