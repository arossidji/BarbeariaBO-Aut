package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;
import lombok.Data;

import java.util.Date;

@Data
public class ServicoDTO {

    Long funcionario;
    Long cliente;
    TipoServico tipoServico;
    Date dataServico;
    Double preco;

}
