package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {

    Long servicoId;
    Long funcionarioId;
    Long clienteId;
    TipoServico tipoServico;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataServico;

    Double preco;

}
