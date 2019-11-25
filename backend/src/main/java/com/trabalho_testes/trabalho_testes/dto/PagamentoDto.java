package com.trabalho_testes.trabalho_testes.dto;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PagamentoDto implements Serializable {

    private Long id;

    private BigDecimal totalPago;

    private String dataPagamento;

    private JogadorDto jogador;

    private PagamentoDto(){}

    private PagamentoDto(Pagamento pagamento){
        this.id = pagamento.getId();
        this.totalPago = pagamento.getTotalPago();
        this.dataPagamento = pagamento.getDataPagamento().toLocalDate().toString();
        this.jogador = JogadorDto.paraDto(pagamento.getJogador());
    }

    public static PagamentoDto paraDto(Pagamento pagamento){
        PagamentoDto pagamentoDto = new PagamentoDto();
        pagamentoDto.setId(pagamento.getId());
        pagamentoDto.setTotalPago(pagamento.getTotalPago());
        pagamentoDto.setDataPagamento(pagamento.getDataPagamento().toLocalDate().toString());
        pagamentoDto.setJogador(JogadorDto.paraDto(pagamento.getJogador()));
        return pagamentoDto;
    }

    public static List<PagamentoDto> paraDto(List<Pagamento> lista){
        return lista.stream().map(PagamentoDto::new).collect(Collectors.toList());
    }

    public static Pagamento doDto(PagamentoDto pagamentoDto){
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoDto.getId());
        if(!StringUtils.isEmpty(pagamentoDto.getDataPagamento())){
            pagamento.setDataPagamento(ZonedDateTime.parse(pagamentoDto.getDataPagamento(), DateTimeFormatter.ISO_DATE));
        }
        pagamento.setTotalPago(pagamentoDto.getTotalPago());
        pagamento.setJogador(JogadorDto.doDto(pagamentoDto.getJogador()));
        return pagamento;
    }

    public static List<Pagamento> doDto(List<PagamentoDto> lista){
        return lista.stream().map(PagamentoDto::doDto).collect(Collectors.toList());
    }

    public static Page<PagamentoDto> paraPageDto(Page<Pagamento> pagina){
        List<PagamentoDto> lista = pagina.getContent().stream()
                .map(pagamento -> new PagamentoDto(pagamento)).collect(Collectors.toList());

        return new PageImpl<>(lista, pagina.getPageable(), pagina.getTotalElements());
    }
}
