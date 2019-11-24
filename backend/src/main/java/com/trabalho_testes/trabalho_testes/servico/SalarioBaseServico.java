package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.SalarioBaseDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.SalarioBase;
import com.trabalho_testes.trabalho_testes.repositorio.SalarioBaseBaseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class SalarioBaseServico implements ISalarioBaseServico {

    @Autowired
    private SalarioBaseBaseJpaRepository salarioBaseBaseJpaRepository;

    @Override
    public SalarioBaseDto cria(Acao acao) {
        return null;
    }

    @Override
    public SalarioBaseDto obtem(Long id) {

        if (ObjectUtils.isEmpty(id)){
            throw new IllegalArgumentException("A id procurada está nula");
        }

        return SalarioBaseDto.paraDto(salarioBaseBaseJpaRepository.findById(id.longValue()));
    }
}
