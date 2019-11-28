package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.repositorio.AcaoJogadorJpaRepository;
import com.trabalho_testes.trabalho_testes.repositorio.AcaoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AcaoServico implements IAcaoServico {

    @Autowired
    private AcaoJpaRepository acaoJpaRepository;


    @Override
    public AcaoDto cria(AcaoDto acao) {
        return AcaoDto.paraDto(acaoJpaRepository.save(AcaoDto.doDto(acao)));
    }

    @Override
    public AcaoDto obtem(Long id) {
        return AcaoDto.paraDto(acaoJpaRepository.findById(id.intValue()));
    }
}
