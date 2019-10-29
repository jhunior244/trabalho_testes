package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.servico.IJogadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
