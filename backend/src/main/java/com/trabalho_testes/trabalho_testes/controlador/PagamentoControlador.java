package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.PagamentoDto;
import com.trabalho_testes.trabalho_testes.gerenciadorexception.GerenciadorException;
import com.trabalho_testes.trabalho_testes.servico.IPagamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("pagamento")
public class PagamentoControlador {

    @Autowired
    private IPagamentoServico pagamentoServico;

    @GetMapping(path = "/cria")
    public PagamentoDto cria(Long idJogador, String data) throws GerenciadorException {

        return pagamentoServico.cria(idJogador, data);
    }

    @GetMapping(path = "/obtem")
    public PagamentoDto obtem(Long id){
        return pagamentoServico.obtem(id);
    }

    @GetMapping(path = "/lista")
    public Page<PagamentoDto> lista(Long mes, Long ano, Long numeroPagina, Long tamanhoPagina){
        if(numeroPagina == null || tamanhoPagina == null){
            numeroPagina = 0L;
            tamanhoPagina = 10L;
        }

        Pageable pagina = PageRequest.of(numeroPagina.intValue(), tamanhoPagina.intValue());

        return PagamentoDto.paraPageDto(pagamentoServico.lista(mes, ano, pagina));
    }
}
