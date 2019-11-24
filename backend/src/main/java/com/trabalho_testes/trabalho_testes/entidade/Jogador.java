package com.trabalho_testes.trabalho_testes.entidade;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer numero;

    private BigDecimal salario;

    private String posicao;

    @OneToMany(mappedBy = "jogador")
    private List<AcaoJogador> listaAcaoJogador;

}
