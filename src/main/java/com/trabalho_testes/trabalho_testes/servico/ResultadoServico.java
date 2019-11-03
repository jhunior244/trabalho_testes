package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.ResultadoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ResultadoServico implements IResultadoServico {
    @Override
    public ResultadoDto cria(Acao acao) {
        return null;
    }

    @Override
    public ResultadoDto obtem(Long id) {
        return null;
    }
}
