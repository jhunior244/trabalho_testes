package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.AcaoJogador;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
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

    private JogoDto jogo;

    private AcaoJogadorDto(AcaoJogador acaoJogador){
        this.id = acaoJogador.getId();
        this.total = acaoJogador.getTotal();
        this.jogador = JogadorDto.paraDto(acaoJogador.getJogador());
        this.acao = AcaoDto.paraDto(acaoJogador.getAcao());
        this.jogo = JogoDto.paraDto(acaoJogador.getJogo());
    }

    public static AcaoJogadorDto paraDto(AcaoJogador acaoJogador){
        return new AcaoJogadorDto(acaoJogador);
    }

    public static List<AcaoJogadorDto> paraDto(List<AcaoJogador> lista){
        return lista.stream().map(AcaoJogadorDto::new).collect(Collectors.toList());
    }

    public static AcaoJogador doDto(AcaoJogadorDto acaoJogadorDto){
        AcaoJogador acaoJogador = new AcaoJogador();
        acaoJogador.setId(acaoJogadorDto.getId());
        acaoJogador.setTotal(acaoJogadorDto.getTotal());
        acaoJogador.setJogador(JogadorDto.doDto(acaoJogadorDto.getJogador()));
        acaoJogador.setAcao(AcaoDto.doDto(acaoJogadorDto.getAcao()));
        acaoJogador.setJogo(JogoDto.doDto(acaoJogadorDto.getJogo()));
        return acaoJogador;
    }

    public static List<AcaoJogador> doDto(List<AcaoJogadorDto> lista){
        return lista.stream().map(AcaoJogadorDto::doDto).collect(Collectors.toList());
    }
}
