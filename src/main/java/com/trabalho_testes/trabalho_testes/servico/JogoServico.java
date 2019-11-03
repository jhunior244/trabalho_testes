package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class JogoServico implements IJogoServico {
    @Override
    public JogoDto cria(Acao acao) {
        return null;
    }

    @Override
    public JogoDto obtem(Long id) {
        return null;
    }
}
