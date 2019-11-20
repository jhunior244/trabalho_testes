package com.trabalho_testes.trabalho_testes.dto;

import com.querydsl.core.util.ArrayUtils;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class JogadorDto implements Serializable {

    private Long id;

    private String nome;

    private Integer numero;

    private List<AcaoJogadorDto> listaAcaoJogador;

    private JogadorDto(){}

    private JogadorDto(Jogador jogador){
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.numero = jogador.getNumero();
        this.listaAcaoJogador = AcaoJogadorDto.paraDto(jogador.getListaAcaoJogador());
    }

    public static JogadorDto paraDto(Jogador jogador){

        JogadorDto jogadorDto = new JogadorDto();
        jogadorDto.setId(jogador.getId());
        jogadorDto.setNome(jogador.getNome());
        jogadorDto.setNumero(jogador.getNumero());
        return jogadorDto;
    }

    public static List<JogadorDto> paraDto(List<Jogador> lista) {
        return lista.stream().map(JogadorDto::new).collect(Collectors.toList());
    }

    public static Jogador doDto(JogadorDto jogadorDto){
        Jogador jogador = new Jogador();
        jogador.setId(jogadorDto.getId());
        jogador.setNome(jogadorDto.getNome());
        jogador.setNumero(jogadorDto.getNumero());
        if(!ObjectUtils.isEmpty(jogadorDto.getListaAcaoJogador())){
            jogador.setListaAcaoJogador(AcaoJogadorDto.doDto(jogadorDto.getListaAcaoJogador()));
        }
        return jogador;
    }

    public static List<Jogador> doDto(List<JogadorDto> lista){
        return lista.stream().map(JogadorDto::doDto).collect(Collectors.toList());
    }

    public static Page<JogadorDto> paraPageDto(Page<Jogador> pagina){
        List<JogadorDto> lista = pagina.getContent().stream()
                .map(jogador -> new JogadorDto(jogador)).collect(Collectors.toList());

        return new PageImpl<>(lista, pagina.getPageable(), pagina.getTotalElements());
    }
}
