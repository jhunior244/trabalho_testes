package com.trabalho_testes.trabalho_testes.entidade;


import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adversario;

    private ZonedDateTime data;

    @ManyToOne
    private Resultado resultado;
}
