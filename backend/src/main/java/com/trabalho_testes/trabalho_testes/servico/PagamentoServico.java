package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.entidade.*;
import com.trabalho_testes.trabalho_testes.gerenciadorexception.GerenciadorException;
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
import java.math.RoundingMode;
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
    public PagamentoDto cria(Long idJogador, String data) throws GerenciadorException {

        Jogador jogador = JogadorDto.doDto(jogadorServico.obtem(idJogador));

        ZonedDateTime dataPagamento = null;

        try{
            dataPagamento = ZonedDateTime.of(LocalDate.parse(data), LocalTime.now(),
                    ZoneId.of("America/Sao_Paulo"));
        } catch (Exception e){
            throw new IllegalArgumentException("Data inválida.");
        }
        return PagamentoDto.paraDto(calculaPagamento(jogador, dataPagamento));
    }


    private Pagamento calculaPagamento(Jogador jogador, ZonedDateTime dataPagamento) throws GerenciadorException {

        if(ObjectUtils.isEmpty(jogador)){
            throw GerenciadorException.criaExcessao("Jogador está nulo.");
        }
        if(ObjectUtils.isEmpty(dataPagamento)){
            throw GerenciadorException.criaExcessao("Data de pagamento está nula.");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setJogador(jogador);
        pagamento.setDataPagamento(dataPagamento);

        BigDecimal pontuacaoMensal = calculaPontuacaoMensal(acaoJogadorJpaRepository.listaPorJogadorEMesDoAno
                (pagamento.getJogador().getId(),
                        dataPagamento.getMonthValue(),
                        dataPagamento.getYear()));

         pagamento.setTotalPago(calculaPagamentoMes(pontuacaoMensal, jogador.getSalario()));
         pagamento = pagamentoJpaRepository.save(pagamento);
        return pagamento;
    }

    private BigDecimal calculaPontuacaoMensal(List<AcaoJogador> lista){
        BigDecimal pontuacaoMensal = BigDecimal.ZERO;
        for(AcaoJogador acaoJogador : lista){
            pontuacaoMensal = pontuacaoMensal.add(acaoJogador.getAcao().getPontos()
                    .multiply(BigDecimal.valueOf(acaoJogador.getTotal())));
        }
        return pontuacaoMensal;
    }

    private BigDecimal calculaPagamentoMes(BigDecimal pontuacaoMensal, BigDecimal salarioBase){
        BigDecimal pagamentoMes = BigDecimal.ZERO;
                pagamentoMes = (pontuacaoMensal.divide(new BigDecimal(100),
                        RoundingMode.HALF_DOWN).add(BigDecimal.ONE))
                .multiply(salarioBase);

        if(pagamentoMes.compareTo(new BigDecimal(100000)) == 1){
            pagamentoMes = new BigDecimal(100000);
        } else if (pagamentoMes.compareTo(new BigDecimal(10000)) == -1){
            pagamentoMes = new BigDecimal(10000);
        }

        return pagamentoMes;
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
