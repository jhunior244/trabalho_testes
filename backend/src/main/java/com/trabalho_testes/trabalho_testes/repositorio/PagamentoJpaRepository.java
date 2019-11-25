package com.trabalho_testes.trabalho_testes.repositorio;

import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.entidade.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagamentoJpaRepository extends JpaRepository<Pagamento, Long>,
        PagamentoJpaRepositoryCustom, PagingAndSortingRepository<Pagamento, Long> {
    Pagamento findById(long id);
}
