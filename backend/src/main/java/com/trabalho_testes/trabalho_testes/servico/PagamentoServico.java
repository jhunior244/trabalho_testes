package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.entidade.*;
import com.trabalho_testes.trabalho_testes.repositorio.AcaoJogadorJpaRepository;
import com.trabalho_testes.trabalho_testes.repositorio.PagamentoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.*;
import java.util.List;

@Component
@Service
@Transactional
public class PagamentoServico implements IPagamentoServico {

    @Autowired
    private IJogadorServico jogadorServico;

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

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
            pagamento.setDataPagamento(ZonedDateTime.of(LocalDate.parse(data), LocalTime.now(),
                    ZoneId.of("America/Sao_Paulo")));
        } catch (Exception e){
            throw new IllegalArgumentException("Data inválida.");
        }
        return PagamentoDto.paraDto(calculaPagamento(pagamento));
    }

    private Pagamento calculaPagamento(Pagamento pagamento){
        BigDecimal salarioBase = pagamento.getJogador().getSalario();

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
                 .multiply(salarioBase);

         if(pagamentoMes.compareTo(new BigDecimal(100000)) == 1){
            pagamentoMes = new BigDecimal(100000);
         } else if (pagamentoMes.compareTo(new BigDecimal(10000)) == -1){
             pagamentoMes = new BigDecimal(10000);
         }
         pagamento.setTotalPago(pagamentoMes);
         pagamento = pagamentoJpaRepository.save(pagamento);
        return pagamento;
    }

    @Override
    public PagamentoDto obtem(Long id) {
        return PagamentoDto.paraDto(pagamentoJpaRepository.findById(id.longValue()));
    }

    @Override
    public Page<Pagamento> lista(Long mes, Long ano, Pageable pagina){
        return pagamentoJpaRepository.lista(mes, ano, pagina);
    }
}
