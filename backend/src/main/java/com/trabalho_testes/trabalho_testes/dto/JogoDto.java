package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Jogo;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class JogoDto implements Serializable {

    private Long id;

    private String adversario;

    private ZonedDateTime data;

    private ResultadoDto resultado;

    private JogoDto(){}

    private JogoDto(Jogo jogo){
        this.id = jogo.getId();
        this.adversario = jogo.getAdversario();
        this.data = jogo.getData();

    }

    public static JogoDto paraDto(Jogo jogo){
        JogoDto jogoDto = new JogoDto();
        jogoDto.setId(jogo.getId());
        jogoDto.setAdversario(jogo.getAdversario());
        jogoDto.setData(jogo.getData());
        jogoDto.setResultado(ResultadoDto.paraDto(jogo.getResultado()));
        return jogoDto;
    }

    public static List<JogoDto> paraDto(List<Jogo> lista){
        return lista.stream().map(JogoDto::new).collect(Collectors.toList());
    }

    public static Jogo doDto(JogoDto jogoDto){
        Jogo jogo = new Jogo();
        jogo.setId(jogoDto.getId());
        jogo.setAdversario(jogoDto.getAdversario());
        jogo.setData(jogoDto.getData());
        jogo.setResultado(ResultadoDto.doDto(jogoDto.getResultado()));
        return jogo;
    }

    public static List<Jogador> doDto(List<JogadorDto> lista){
        return lista.stream().map(JogadorDto::doDto).collect(Collectors.toList());
    }
}
