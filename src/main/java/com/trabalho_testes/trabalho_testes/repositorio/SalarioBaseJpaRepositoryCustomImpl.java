package com.trabalho_testes.trabalho_testes.repositorio;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trabalho_testes.trabalho_testes.entidade.QSalarioBase;
import com.trabalho_testes.trabalho_testes.entidade.SalarioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class SalarioBaseJpaRepositoryCustomImpl implements SalarioBaseJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public SalarioBase obtemPorJogador(Long idJogador){

        QSalarioBase qSalarioBase = QSalarioBase.salarioBase;

        JPQLQuery<SalarioBase> query = jpaQueryFactory.selectFrom(qSalarioBase);

        BooleanExpression predicado = qSalarioBase.id.isNotNull();

        if(!ObjectUtils.isEmpty(idJogador)){
            predicado = predicado.and(qSalarioBase.jogador.id.eq(idJogador));
        }

        query.where(predicado);

        return query.fetchFirst();
    }

}
