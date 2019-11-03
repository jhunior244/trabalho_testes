package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.dto.SalarioBaseDto;
import com.trabalho_testes.trabalho_testes.entidade.*;
import com.trabalho_testes.trabalho_testes.repositorio.AcaoJogadorJpaRepository;
import com.trabalho_testes.trabalho_testes.repositorio.PagamentoJpaRepository;
import com.trabalho_testes.trabalho_testes.repositorio.SalarioBaseBaseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Service
@Transactional
public class PagamentoServico implements IPagamentoServico {

    @Autowired
    private IJogadorServico jogadorServico;

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Autowired
    private SalarioBaseBaseJpaRepository salarioBaseBaseJpaRepository;

    @Autowired
    private AcaoJogadorJpaRepository acaoJogadorJpaRepository;

    @Override
    public PagamentoDto cria(Long idJogador, String data) {

        Jogador jogador = JogadorDto.doDto(jogadorServico.obtem(idJogador));

        if(ObjectUtils.isEmpty(jogador)){
            throw new IllegalArgumentException("O jogador indicado é inválido.");
        }
        Pagamento pagamento = new Pagamento();
        pagamento.setJogador(jogador);

        try{
            pagamento.setDataPagamento(ZonedDateTime.of(LocalDate.parse(data), LocalTime.now(), ZoneId.of("America/Sao_Paulo")));
        } catch (Exception e){
            throw new IllegalArgumentException("Data inválida.");
        }
        return PagamentoDto.paraDto(calculaPagamento(pagamento));
    }

    private Pagamento calculaPagamento(Pagamento pagamento){
        SalarioBase salarioBase = salarioBaseBaseJpaRepository.obtemPorJogador(pagamento.getJogador().getId());

        Integer mesPagamento = pagamento.getDataPagamento().getMonthValue();

        Integer anoPagamento = pagamento.getDataPagamento().getYear();

        List<AcaoJogador> lista = acaoJogadorJpaRepository
                .listaPorJogadorEMesDoAno(pagamento.getJogador().getId(), mesPagamento, anoPagamento);

        BigDecimal pontuacaoMensal = BigDecimal.ZERO;

         for(AcaoJogador acaoJogador : lista){
             pontuacaoMensal = pontuacaoMensal.add(acaoJogador.getAcao().getPontos().multiply(BigDecimal.valueOf(acaoJogador.getTotal())));
         }

         pagamento.setDataPagamento(ZonedDateTime.now());

         BigDecimal pagamentoMes = (pontuacaoMensal.divide(new BigDecimal(100)).add(BigDecimal.ONE))
                 .multiply(salarioBase.getSalario());

         if(pagamentoMes.compareTo(new BigDecimal(100000)) == 1){
            pagamentoMes = new BigDecimal(100000);
         } else if (pagamentoMes.compareTo(new BigDecimal(10000)) == -1){
             pagamentoMes = new BigDecimal(10000);
         } else {
             pagamento.setTotalPago(pagamentoMes);
         }
         pagamento = pagamentoJpaRepository.save(pagamento);
        return pagamento;
    }

    @Override
    public PagamentoDto obtem(Long id) {
        return PagamentoDto.paraDto(pagamentoJpaRepository.findById(id.longValue()));
    }
}
