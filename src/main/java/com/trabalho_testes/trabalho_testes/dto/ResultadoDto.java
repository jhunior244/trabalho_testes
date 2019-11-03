package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Resultado;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResultadoDto implements Serializable {

    private Long id;

    private String nome;

    private ResultadoDto(){}

    private ResultadoDto(Resultado resultado){
        this.id = resultado.getId();
        this.nome = resultado.getNome();
    }

    public static ResultadoDto paraDto(Resultado resultado){
        ResultadoDto resultadoDto = new ResultadoDto();
        resultadoDto.setId(resultado.getId());
        resultadoDto.setNome(resultado.getNome());
        return resultadoDto;
    }

    public static List<ResultadoDto> paraDto(List<Resultado> lista){
        return lista.stream().map(ResultadoDto::new).collect(Collectors.toList());
    }

    public static Resultado doDto(ResultadoDto resultadoDto){
        Resultado resultado = new Resultado();
        resultado.setId(resultadoDto.getId());
        resultado.setNome(resultadoDto.getNome());
        return resultado;
    }

    public static List<Resultado> doDto(List<ResultadoDto> lista){
        return lista.stream().map(ResultadoDto::doDto).collect(Collectors.toList());
    }
}
