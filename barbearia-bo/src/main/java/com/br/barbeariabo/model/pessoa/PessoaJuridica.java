package com.br.barbeariabo.model.pessoa;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class PessoaJuridica extends Pessoa{

    protected String nome;
    protected String cnpj;

}
