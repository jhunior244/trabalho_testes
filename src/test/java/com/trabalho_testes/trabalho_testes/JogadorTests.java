package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.servico.JogadorServico;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrabalhoTestesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JogadorTests {

    @Autowired
    private JogadorServico jogadorServico;
}
