package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PagamentoDto implements Serializable {

    private Long id;

    private BigDecimal totalPago;

    private ZonedDateTime dataPagamento;

    private JogadorDto jogador;

    private PagamentoDto(){}

    private PagamentoDto(Pagamento pagamento){
        this.id = pagamento.getId();
        this.totalPago = pagamento.getTotalPago();
        this.dataPagamento = pagamento.getDataPagamento();
        this.jogador = JogadorDto.paraDto(pagamento.getJogador());
    }

    public static PagamentoDto paraDto(Pagamento pagamento){
        PagamentoDto pagamentoDto = new PagamentoDto();
        pagamentoDto.setId(pagamento.getId());
        pagamentoDto.setTotalPago(pagamento.getTotalPago());
        pagamentoDto.setDataPagamento(pagamento.getDataPagamento());
        pagamentoDto.setJogador(JogadorDto.paraDto(pagamento.getJogador()));
        return pagamentoDto;
    }

    public static List<PagamentoDto> paraDto(List<Pagamento> lista){
        return lista.stream().map(PagamentoDto::new).collect(Collectors.toList());
    }
}
