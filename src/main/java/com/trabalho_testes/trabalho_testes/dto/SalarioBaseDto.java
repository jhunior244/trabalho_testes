package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.SalarioBase;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SalarioBaseDto implements Serializable {

    private Long id;

    private BigDecimal salario;

    private JogadorDto jogador;

    private SalarioBaseDto(){}

    private SalarioBaseDto(SalarioBase salarioBase){
        this.id = salarioBase.getId();
        this.salario = salarioBase.getSalario();
        this.jogador = JogadorDto.paraDto(salarioBase.getJogador());
    }

    public static SalarioBaseDto paraDto(SalarioBase salarioBase){
        SalarioBaseDto salarioBaseDto = new SalarioBaseDto();
        salarioBaseDto.setId(salarioBase.getId());
        salarioBaseDto.setSalario(salarioBase.getSalario());
        salarioBaseDto.setJogador(JogadorDto.paraDto(salarioBase.getJogador()));
        return salarioBaseDto;
    }

    public static List<SalarioBaseDto> paraDto(List<SalarioBase> lista){
        return lista.stream().map(SalarioBaseDto::new).collect(Collectors.toList());
    }
}
