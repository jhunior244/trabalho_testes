package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.servico.IJogadorServico;
import com.trabalho_testes.trabalho_testes.servico.IPagamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("pagamento")
public class PagamentoControlador {

    @Autowired
    private IPagamentoServico pagamentoServico;

    @PostMapping(path = "/cria")
    public PagamentoDto cria(Long idJogador,String data){

        return pagamentoServico.cria(idJogador, data);
    }

    @GetMapping(path = "/obtem")
    public PagamentoDto obtem(Long id){
        return pagamentoServico.obtem(id);
    }
}
