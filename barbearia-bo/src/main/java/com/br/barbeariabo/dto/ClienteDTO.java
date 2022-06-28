package com.br.barbeariabo.dto;

import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.servico.Servico;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ClienteDTO {


    @NotNull
    public String nomeCompleto;
    @NotNull
    public String email;
    @NotNull
    public String rua;
    @NotNull
    public String bairro;
    @NotNull
    public String numero;
    @NotNull
    public String cidade;
    @NotNull
    public String uf;
    @NotNull
    public String telefone;

}
