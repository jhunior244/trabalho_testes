package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AcaoServico implements IAcaoServico {
    @Override
    public AcaoDto cria(Acao acao) {
        return null;
    }

    @Override
    public AcaoDto obtem(Long id) {
        return null;
    }
}
