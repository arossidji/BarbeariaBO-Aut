package com.br.barbeariabo.dto;

import com.br.barbeariabo.model.endereco.Endereco;
import lombok.Data;

import java.util.Date;

@Data
public class ClienteDTO {

    public String nomeCompleto;
    public String email;
    public String rua;
    public String bairro;
    public String numero;
    public String cidade;
    public String uf;
    public String telefone;

}
