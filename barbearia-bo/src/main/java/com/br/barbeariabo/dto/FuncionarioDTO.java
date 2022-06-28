package com.br.barbeariabo.dto;

import com.sun.istack.NotNull;
import lombok.Data;



@Data
public class FuncionarioDTO {

    @NotNull
    public String nome;

    @NotNull
    public String posicao;

    @NotNull
    public String descricao;

    @NotNull
    public String telefone;

    @NotNull
    public String loginFuncionario;

}
