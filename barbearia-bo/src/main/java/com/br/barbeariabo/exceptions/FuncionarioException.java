package com.br.barbeariabo.exceptions;

public class FuncionarioException extends Exception{

    public FuncionarioException(){
        super("Funcionario não encontrado, favor cadastrar!");
    }

}
