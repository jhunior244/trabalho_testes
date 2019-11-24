package com.trabalho_testes.trabalho_testes.entidade;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Resultado {

    public enum Valores {
        VITORIA(1, "VITORIA"),
        EMPATE(2, "EMPATE"),
        DERROTA(3, "DERROTA");

        private long id;
        private String nome;

        Valores(int id, String nome) {
            this.nome = nome;
            this.id = id;
        }

        public long obtemId() {
            return this.id;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
}
