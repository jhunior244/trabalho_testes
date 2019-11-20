package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.repositorio.JogadorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@Service
@Transactional
public class JogadorServico implements IJogadorServico {

    @Autowired
    private JogadorJpaRepository jogadorJpaRepository;

    @Override
    public JogadorDto cria(Jogador jogador) {

        if(ObjectUtils.isEmpty(jogador)){
            throw new IllegalArgumentException("O jogador está nulo.");
        }
        return JogadorDto.paraDto(jogadorJpaRepository.save(jogador));
    }

    @Override
    public JogadorDto obtem(Long id) {

        if (ObjectUtils.isEmpty(id)){
            throw new IllegalArgumentException("A id procurada está nula");
        }
        return JogadorDto.paraDto(jogadorJpaRepository.findById(id.longValue()));
    }

    @Override
    public Page<Jogador> lista(Pageable pagina){
        return jogadorJpaRepository.lista(pagina);
    }
}


