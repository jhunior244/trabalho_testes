package com.trabalho_testes.trabalho_testes.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SalarioBaseDto implements Serializable {

    private Long id;

    private BigDecimal salario;

    private JogadorDto jogador;
}
