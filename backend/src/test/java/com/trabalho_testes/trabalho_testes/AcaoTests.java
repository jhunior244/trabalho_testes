package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.servico.AcaoServico;
import com.trabalho_testes.trabalho_testes.servico.JogadorServico;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrabalhoTestesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcaoTests {

    @Autowired
    private AcaoServico acaoServico;

    @LocalServerPort
    private int port = 8080;

    private String endpoint = "/acao/";
    private String endpointObtem = "obtem";
    private String endpointCria = "cria";
    private String endpointLista = "lista";
    private String endpointAtualiza = "atualiza";
    private String endpointListaTodos = "listaTodos";
    private final Long id = 1L;

    @Before
    public void setPort(){
        RestAssured.port = port;
    }

    @Test
    public void shouldReturnSucessfullyWhenCria(){

        AcaoDto acao = new AcaoDto();
        acao.setNome("Gol Contra");
        acao.setPontos(new BigDecimal(-2));

        RestAssured.given().header("Content-Type", "application/json")
                .body(acao)
                .when().post(endpoint.concat(endpointCria))
                .then().statusCode(200).and()
                .body("nome", equalTo("Gol Contra"));
    }

    @Test
    public void shouldReturnSucessfullyWhenObtem(){
        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("id",5)
                .when().get(endpoint.concat(endpointObtem))
                .then().statusCode(200).and()
                .body("nome", equalTo("Gol Contra"));
    }
}
