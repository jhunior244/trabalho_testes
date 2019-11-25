package com.trabalho_testes.trabalho_testes.repositorio;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import com.trabalho_testes.trabalho_testes.entidade.QJogador;
import com.trabalho_testes.trabalho_testes.entidade.QPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class PagamentoJpaRepositoryCustomImpl implements PagamentoJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Pagamento> lista(Long mes, Long ano, Pageable pagina) {

        QPagamento pagamento = QPagamento.pagamento;

        JPQLQuery<Pagamento> query = jpaQueryFactory.selectFrom(pagamento);

        BooleanExpression predicado = pagamento.id.isNotNull();

        if(!ObjectUtils.isEmpty(mes)){
            predicado = predicado.and(pagamento.dataPagamento.month().eq(mes.intValue()));
        }

        if(!ObjectUtils.isEmpty(ano)){
            predicado = predicado.and(pagamento.dataPagamento.month().eq(ano.intValue()));
        }

        query.where(predicado);

        query.limit(pagina.getPageSize());

        query.offset(pagina.getOffset());

        List<Pagamento> lista = query.fetch();

        return new PageImpl<>(lista, pagina, query.fetchCount());
    }
}
