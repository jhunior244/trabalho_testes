package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.servico.AcaoJogadorServico;
import com.trabalho_testes.trabalho_testes.servico.AcaoServico;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrabalhoTestesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcaoJogadorTests {

    @Autowired
    private AcaoJogadorServico acaoJogadorServico;

    @LocalServerPort
    private int port = 8080;

    private String endpoint = "/acaoJogador/";
    private String endpointListaPorJogadorEMesDoAno = "listaPorJogadorEMesDoAno";


    @Before
    public void setPort(){
        RestAssured.port = port;
    }

    @Test
    public void shouldReturnSucessfullyWhenListaPorJogadorEMesDoAno(){
        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("idJogador",1)
                .queryParam("mes","11")
                .queryParam("ano", "2019")
                .when().get(endpoint.concat(endpointListaPorJogadorEMesDoAno))
                .then().statusCode(200);
    }
}
