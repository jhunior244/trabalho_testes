package com.trabalho_testes.trabalho_testes.entidade;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal pontos;

    @OneToMany(mappedBy = "acao")
    private List<AcaoJogador> listaAcaoJogador;
}
