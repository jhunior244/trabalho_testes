package com.trabalho_testes.trabalho_testes.entidade;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal totalPago;

    @Column(nullable = false)
    private ZonedDateTime dataPagamento;

    @ManyToOne
    private Jogador jogador;
}
