package com.trabalho_testes.trabalho_testes.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class PagamentoDto implements Serializable {

    private Long id;

    private BigDecimal totalPago;

    private ZonedDateTime dataPagamento;

    private JogadorDto jogador;
}
