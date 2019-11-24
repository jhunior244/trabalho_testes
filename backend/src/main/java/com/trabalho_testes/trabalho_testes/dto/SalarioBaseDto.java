package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
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

    private SalarioBaseDto(){}

    private SalarioBaseDto(SalarioBase salarioBase){
        this.id = salarioBase.getId();
        this.salario = salarioBase.getSalario();
    }

    public static SalarioBaseDto paraDto(SalarioBase salarioBase){
        SalarioBaseDto salarioBaseDto = new SalarioBaseDto();
        salarioBaseDto.setId(salarioBase.getId());
        salarioBaseDto.setSalario(salarioBase.getSalario());
        return salarioBaseDto;
    }

    public static List<SalarioBaseDto> paraDto(List<SalarioBase> lista){
        return lista.stream().map(SalarioBaseDto::new).collect(Collectors.toList());
    }

    public static SalarioBase doDto(SalarioBaseDto salarioBaseDto){
        SalarioBase salarioBase = new SalarioBase();
        salarioBase.setId(salarioBaseDto.getId());
        salarioBase.setSalario(salarioBaseDto.getSalario());
        return salarioBase;
    }

    public static List<SalarioBase> doDto(List<SalarioBaseDto> lista){
        return lista.stream().map(SalarioBaseDto::doDto).collect(Collectors.toList());
    }
}
