package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import com.trabalho_testes.trabalho_testes.repositorio.PagamentoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class PagamentoServico implements IPagamentoServico {

    @Autowired
    private JogadorServico jogadorServico;

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Override
    public PagamentoDto cria(Long idJogador, String data) {

        Jogador jogador = JogadorDto.doDto(jogadorServico.obtem(idJogador));

        if(ObjectUtils.isEmpty(jogador)){
            throw new IllegalArgumentException("O jogador indicado é inválido.");
        }
        Pagamento pagamento = new Pagamento();
        pagamento.setJogador(jogador);

        try{
            pagamento.setDataPagamento(ZonedDateTime.parse(data, DateTimeFormatter.ISO_DATE));
        } catch (Exception e){
            throw new IllegalArgumentException("Data inválida.");
        }
        return PagamentoDto.paraDto(calculaPagamento(pagamento));
    }

    private Pagamento calculaPagamento(Pagamento pagamento){
        //TODO: implementar depois
        return null;
    }

    @Override
    public PagamentoDto obtem(Long id) {
        return null;
    }
}
