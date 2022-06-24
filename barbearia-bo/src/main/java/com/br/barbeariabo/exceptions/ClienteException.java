package com.br.barbeariabo.exceptions;

public class ClienteException extends Exception {

    public ClienteException(){
        super("Cliente não encontrado, favor cadastrar!");
    }

}
