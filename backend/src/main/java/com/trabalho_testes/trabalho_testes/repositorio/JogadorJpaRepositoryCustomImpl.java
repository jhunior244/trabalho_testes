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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class JogadorJpaRepositoryCustomImpl implements JogadorJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Jogador> lista(String nome, Long numero, Pageable pagina) {

        QJogador qJogador = QJogador.jogador;

        JPQLQuery<Jogador> query = jpaQueryFactory.selectFrom(qJogador);

        BooleanExpression predicado = qJogador.id.isNotNull();

        if(!StringUtils.isEmpty(nome)){
            predicado = predicado.and(qJogador.nome.containsIgnoreCase(nome));
        }

        if(!ObjectUtils.isEmpty(numero)){
            predicado = predicado.and(qJogador.numero.eq(numero.intValue()));
        }

        query.where(predicado);

        query.limit(pagina.getPageSize());

        query.offset(pagina.getOffset());

        List<Jogador> lista = query.fetch();

        return new PageImpl<>(lista, pagina, query.fetchCount());
    }

}
