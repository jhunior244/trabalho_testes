package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoJpaRepository extends JpaRepository<Resultado, Long>, ResultadoJpaRepositoryCustom {
    Resultado findById(long id);
}
