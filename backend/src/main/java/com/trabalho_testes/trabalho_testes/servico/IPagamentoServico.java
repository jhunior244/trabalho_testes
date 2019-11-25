package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPagamentoServico {

    PagamentoDto cria(Long idJogador,String data);

    PagamentoDto obtem(Long id);

    Page<Pagamento> lista(Long mes, Long ano, Pageable pagina);
}
