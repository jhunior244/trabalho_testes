package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AcaoDto implements Serializable {

    private Long id;

    private String nome;

    private BigDecimal pontos;

    private List<AcaoJogadorDto> listaAcaoJogador;

    private AcaoDto(){}

    private AcaoDto(Acao acao){
        this.id = acao.getId();
        this.nome = acao.getNome();
        this.pontos = acao.getPontos();
    }

    public static AcaoDto paraDto(Acao acao){
        AcaoDto acaoDto = new AcaoDto();
        acaoDto.setId(acao.getId());
        acaoDto.setNome(acao.getNome());
        acao.setPontos(acao.getPontos());
        return acaoDto;
    }

    public static List<AcaoDto> paraDto(List<Acao> lista) {
        return lista.stream().map(AcaoDto::new).collect(Collectors.toList());
    }

    public static Acao doDto(AcaoDto acaoDto){
        Acao acao = new Acao();
        acao.setId(acaoDto.getId());
        acao.setNome(acaoDto.getNome());
        acao.setListaAcaoJogador(AcaoJogadorDto.doDto(acaoDto.getListaAcaoJogador()));
        return acao;
    }

    public static List<Acao> doDto(List<AcaoDto> lista){
        return lista.stream().map(AcaoDto::doDto).collect(Collectors.toList());
    }

}
