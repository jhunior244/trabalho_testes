package com.trabalho_testes.trabalho_testes.repositorio;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoJpaRepositoryCustomImpl implements PagamentoJpaRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public void teste(){

    }
}
