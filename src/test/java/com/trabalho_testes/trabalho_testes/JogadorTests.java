package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.servico.JogadorServico;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrabalhoTestesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JogadorTests {

    @Autowired
    private JogadorServico jogadorServico;

    @LocalServerPort
    private int port = 8080;

    private String endpoint = "/jogador/";
    private String endpointObtem = "obtem";
    private final Long id = 1L;

    @Before
    public void setPort(){
        RestAssured.port = port;
    }

    @Test
    public void shouldReturnSucessfullyWhenFindByCourse(){
        RestAssured.given().header("Content-Type", "application/json").queryParam("id",1)
                .when().get(endpoint.concat(endpointObtem))
                .then().statusCode(200).and()
                .body("nome", equalTo("jogador teste"));
    }
}
