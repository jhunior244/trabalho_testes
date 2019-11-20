package com.trabalho_testes.trabalho_testes.servico;


import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorServico {

    JogadorDto cria(Jogador jogador);

    JogadorDto obtem(Long id);

    Page<Jogador> lista(Pageable pagina);

}
