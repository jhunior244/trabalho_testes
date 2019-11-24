package com.trabalho_testes.trabalho_testes;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EntityScan(basePackageClasses = {TrabalhoTestesApplication.class})
@ComponentScan(basePackages = "com.trabalho_testes.trabalho_testes.controlador")
@ComponentScan(basePackages = "com.trabalho_testes.trabalho_testes.servico")
@ComponentScan(basePackages = "com.trabalho_testes.trabalho_testes.repositorio")
public class TrabalhoTestesApplication {

	@PersistenceContext
	private EntityManager em;
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoTestesApplication.class, args);
	}

	@Bean
	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
		return new OpenEntityManagerInViewFilter();
	}


	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(em);
	}
}
