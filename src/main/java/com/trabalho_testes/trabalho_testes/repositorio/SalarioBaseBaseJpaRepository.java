package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.SalarioBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioBaseBaseJpaRepository extends JpaRepository<SalarioBase, Long>, SalarioBaseJpaRepositoryCustom {
    SalarioBase findById(long id);
}
