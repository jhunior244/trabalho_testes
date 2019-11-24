package com.trabalho_testes.trabalho_testes.controlador;

import com.trabalho_testes.trabalho_testes.servico.IAcaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("acao")
public class AcaoControlador {

    @Autowired
    private IAcaoServico acaoServico;
}
