package com.br.barbeariabo.model.pessoa;

import lombok.Data;

@Data
public class PessoaJuridica extends Pessoa{

    protected String nome;
    protected String cnpj;

}
