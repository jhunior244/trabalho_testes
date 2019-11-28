package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.dto.AcaoDto;
import com.trabalho_testes.trabalho_testes.dto.JogadorDto;
import com.trabalho_testes.trabalho_testes.gerenciadorexception.GerenciadorException;
import com.trabalho_testes.trabalho_testes.servico.IAcaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("acao")
public class AcaoControlador {

    @Autowired
    private IAcaoServico acaoServico;

    @PostMapping(path = "/cria")
    public AcaoDto cria(@RequestBody AcaoDto acaoDto) throws GerenciadorException {
        return acaoServico.cria(acaoDto);
    }

    @GetMapping(path = "/obtem")
    public AcaoDto obtem(Long id){
        return acaoServico.obtem(id);
    }
}
