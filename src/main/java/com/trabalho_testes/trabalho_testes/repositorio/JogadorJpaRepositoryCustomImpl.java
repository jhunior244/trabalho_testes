package com.trabalho_testes.trabalho_testes.repositorio;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.QJogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JogadorJpaRepositoryCustomImpl implements JogadorJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Jogador> lista(Pageable pagina) {

        QJogador qJogador = QJogador.jogador;

        JPQLQuery<Jogador> query = jpaQueryFactory.selectFrom(qJogador);

        BooleanExpression predicado = qJogador.id.isNotNull();

        predicado = predicado.and(qJogador.nome.eq("jogador teste"));

        query.where(predicado);

        query.limit(pagina.getPageSize());

        query.offset(pagina.getOffset());

        List<Jogador> lista = query.fetch();

        return new PageImpl<>(lista, pagina, query.fetchCount());
    }

}
