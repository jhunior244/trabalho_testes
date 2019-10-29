package com.trabalho_testes.trabalho_testes.entidade;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class SalarioBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal salario;

    @OneToOne
    private Jogador jogador;
}
