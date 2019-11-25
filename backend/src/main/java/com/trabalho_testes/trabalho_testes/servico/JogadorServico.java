package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.gerenciadorexception.GerenciadorException;
import com.trabalho_testes.trabalho_testes.repositorio.JogadorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Transactional
public class JogadorServico implements IJogadorServico {

    @Autowired
    private JogadorJpaRepository jogadorJpaRepository;

    @Override
    public JogadorDto cria(Jogador jogador) throws GerenciadorException {

        if(ObjectUtils.isEmpty(jogador)){
            throw GerenciadorException.criaExcessao("O jogador está nulo.");
        }
        return JogadorDto.paraDto(jogadorJpaRepository.save(jogador));
    }

    @Override
    public JogadorDto atualiza(Jogador jogador) throws GerenciadorException {
        Jogador jogadorBanco = jogadorJpaRepository.findById(jogador.getId().longValue());

        jogadorBanco.setNome(jogador.getNome());
        jogadorBanco.setNumero(jogador.getNumero());
        jogadorBanco.setSalario(jogador.getSalario());
        jogadorBanco.setPosicao(jogador.getPosicao());

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
    public Page<Jogador> lista(String nome, Long numero, Pageable pagina){
        return jogadorJpaRepository.lista(nome, numero, pagina);
    }

    @Override
    public List<Jogador> listaTodos(){
        List<Jogador> lista = jogadorJpaRepository.findAll();
        return lista;
    }

}


