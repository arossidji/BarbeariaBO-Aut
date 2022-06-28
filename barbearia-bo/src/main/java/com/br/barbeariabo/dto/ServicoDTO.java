package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {

    @NotNull
    Long servicoId;

    @NotNull
    Long funcionarioId;

    @NotNull
    Long clienteId;

    @NotNull
    TipoServico tipoServico;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataServico;

    @NotNull
    Double preco;

}
