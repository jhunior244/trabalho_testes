package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Jogador;
import com.trabalho_testes.trabalho_testes.servico.IJogadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("jogador")
public class JogadorControlador {

    @Autowired
    private IJogadorServico jogadorServico;

    @PostMapping(path = "/cria")
    public JogadorDto cria(@RequestBody JogadorDto jogadorDto){

        return jogadorServico.cria(null);
    }

    @GetMapping(path = "/obtem")
    public JogadorDto obtem(Long id){
        return jogadorServico.obtem(id);
    }

    @GetMapping(path = "/lista")
    public Page<JogadorDto> lista(Long numeroPagina, Long tamanhoPagina){
        if(numeroPagina == null || tamanhoPagina == null){
            numeroPagina = 0L;
            tamanhoPagina = 10L;
        }

        Pageable pagina = PageRequest.of(numeroPagina.intValue(), tamanhoPagina.intValue());


        Page<Jogador> page = jogadorServico.lista(pagina);

        return JogadorDto.paraPageDto(page);
    }
}


