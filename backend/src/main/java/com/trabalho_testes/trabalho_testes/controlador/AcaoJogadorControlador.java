package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.AcaoJogadorDto;
import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.servico.IAcaoJogadorServico;
import com.trabalho_testes.trabalho_testes.servico.IJogadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("acaoJogador")
public class AcaoJogadorControlador {

    @Autowired
    private IAcaoJogadorServico acaoJogadorServico;

    @PostMapping(path = "/cria")
    public AcaoJogadorDto cria(@RequestBody AcaoJogadorDto acaoJogadorDto){

        return acaoJogadorServico.cria(acaoJogadorDto);
    }

    @GetMapping(path = "/obtem")
    public AcaoJogadorDto obtem(Long id){
        return acaoJogadorServico.obtem(id);
    }

    @GetMapping(path = "/listaPorJogadorEMesDoAno")
    public List<AcaoJogadorDto> listaPorJogadorEMesDoAno(Long idJogador, Integer mes, Integer ano){

        return acaoJogadorServico.listaPorJogadorEMesDoAno(idJogador, mes, ano);
    }
}

