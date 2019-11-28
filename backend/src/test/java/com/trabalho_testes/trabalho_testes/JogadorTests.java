package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.servico.JogadorServico;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

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
    public void shouldReturnSucessfullyWhenObtem(){
        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("id",1)
                .when().get(endpoint.concat(endpointObtem))
                .then().statusCode(200).and()
                .body("nome", equalTo("jogador teste"));
    }

    @Test
    public void shouldReturnSucessfullyWhenLista(){
        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("nome","")
                .queryParam("numero",1)
                .queryParam("numeroPagina", 0)
                .queryParam("tamanhoPagina", 10)
                .when().get(endpoint.concat(endpointLista))
                .then().statusCode(200);
    }

    @Test
    public void shouldReturnSucessfullyWhenCria(){

        JogadorDto jogadorDto = new JogadorDto();
        jogadorDto.setNome("Ronaldo Fenomeno");
        jogadorDto.setNumero(9);
        jogadorDto.setPosicao("Atacante");
        jogadorDto.setSalario(new BigDecimal(10000000));

        RestAssured.given().header("Content-Type", "application/json")
                .body(jogadorDto)
                .when().post(endpoint.concat(endpointCria))
                .then().statusCode(200).and()
                .body("nome", equalTo("Ronaldo Fenomeno"));
    }

    @Test
    public void shouldReturnSucessfullyWhenListaAtualiza(){

        JogadorDto jogador = jogadorServico.obtem(1L);

        jogador.setNome("Teste atualiza jogador");

        RestAssured.given().header("Content-Type", "application/json")
                .body(jogador)
                .when().post(endpoint.concat(endpointCria))
                .then().statusCode(200).and()
                .body("nome", equalTo("Teste atualiza jogador"));
    }

    @Test
    public void shouldReturnSucessfullyWhenListaTodos(){

        RestAssured.given().header("Content-Type", "application/json")
                .when().get(endpoint.concat(endpointListaTodos))
                .then().statusCode(200);
    }
}



