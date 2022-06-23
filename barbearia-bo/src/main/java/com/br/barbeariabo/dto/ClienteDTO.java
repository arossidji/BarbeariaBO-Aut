package com.br.barbeariabo.dto;

import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.servico.Servico;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
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
