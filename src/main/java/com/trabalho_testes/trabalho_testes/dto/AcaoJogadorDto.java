package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AcaoJogadorDto implements Serializable {

    private Long id;

    private Integer total;

    private JogadorDto jogador;

    private AcaoDto acao;

    private AcaoJogadorDto(AcaoJogador acaoJogador){
        this.id = acaoJogador.getId();
        this.total = acaoJogador.getTotal();
        this.jogador = JogadorDto.paraDto(acaoJogador.getJogador());
        this.acao = AcaoDto.paraDto(acaoJogador.getAcao());
    }

    public static AcaoJogadorDto paraDto(AcaoJogador acaoJogador){
        return new AcaoJogadorDto(acaoJogador);
    }

    public static List<AcaoJogadorDto> paraDto(List<AcaoJogador> lista){
        return lista.stream().map(AcaoJogadorDto::new).collect(Collectors.toList());
    }
}
