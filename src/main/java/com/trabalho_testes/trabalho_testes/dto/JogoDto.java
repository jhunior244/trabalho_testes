package com.trabalho_testes.trabalho_testes.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JogoDto implements Serializable {

    private Long id;

    private String nome;

    private Integer numero;

    private ResultadoDto resultado;
}
