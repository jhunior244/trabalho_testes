package com.trabalho_testes.trabalho_testes.gerenciadorexception;

public class GerenciadorException extends Exception {

    private String erro;
    private int status;

    public static GerenciadorException criaExcessao(String erro){
        GerenciadorException excessao = new GerenciadorException();
        excessao.erro = erro;
        excessao.status = 400;
        return excessao;
    }
}
