package com.trabalho_testes.trabalho_testes;

import com.trabalho_testes.trabalho_testes.servico.IPagamentoServico;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

public class PagamentoTests {

    @Autowired
    private IPagamentoServico pagamentoServico;

    @LocalServerPort
    private int port = 8080;

    private String endpoint = "/pagamento/";
    private String endPointCria = "cria";
    private final Long idJogador = 1L;
    private final String data = "2019-11-03";

    @Before
    public void setPort(){
        RestAssured.port = port;
    }

    @Test
    public void shouldReturnSucessfullyWhenCria(){

        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("idJogador",1).queryParam("data", "2019-11-03")
                .when().post(endpoint.concat(endPointCria))
                .then().statusCode(200).and();
    }
}
