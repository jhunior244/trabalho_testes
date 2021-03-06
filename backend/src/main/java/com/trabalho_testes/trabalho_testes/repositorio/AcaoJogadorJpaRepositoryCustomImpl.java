package com.trabalho_testes.trabalho_testes.repositorio;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trabalho_testes.trabalho_testes.entidade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class AcaoJogadorJpaRepositoryCustomImpl implements AcaoJogadorJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<AcaoJogador> listaPorJogadorEMesDoAno(Long idJogador, Integer mes, Integer ano){

        QAcaoJogador acaoJogador = QAcaoJogador.acaoJogador;

        JPQLQuery<AcaoJogador> query = jpaQueryFactory.selectFrom(acaoJogador);

        BooleanExpression predicado = acaoJogador.id.isNotNull();

        if(ObjectUtils.isEmpty(idJogador) || ObjectUtils.isEmpty(mes) || ObjectUtils.isEmpty(ano)){
            return new ArrayList<>();
        }

        predicado = predicado.and(acaoJogador.jogador.id.eq(idJogador));

        predicado = predicado.and(acaoJogador.jogo.data.month().eq(mes.intValue()));

        predicado = predicado.and(acaoJogador.jogo.data.year().eq(ano.intValue()));

        query.where(predicado);

        List<AcaoJogador> lista =  query.fetch();

        return lista;
    }


}




