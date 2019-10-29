package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.repositorio.JogadorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
