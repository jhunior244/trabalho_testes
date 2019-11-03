package com.trabalho_testes.trabalho_testes.entidade;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AcaoJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer total;

    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Acao acao;

    @ManyToOne
    private Jogo jogo;
}
