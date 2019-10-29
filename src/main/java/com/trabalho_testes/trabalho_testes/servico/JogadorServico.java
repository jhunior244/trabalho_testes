package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.repositorio.JogadorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class JogadorServico implements IJogadorServico {

    @Autowired
    private JogadorJpaRepository jogadorJpaRepository;

    @Override
    public JogadorDto cria(Jogador jogador) {
        return JogadorDto.paraDto(jogadorJpaRepository.save(jogador));
    }

    @Override
    public JogadorDto obtem(Long id) {

        if (ObjectUtils.isEmpty(id)){
            throw new IllegalArgumentException("A id do jogador procurado está nula");
        }

        return JogadorDto.paraDto(jogadorJpaRepository.findById(id.longValue()));
    }
}
