package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoJpaRepositoryCustom {

    Page<Pagamento> lista(Long mes, Long ano, Pageable pagina);
}
