package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoClienteDTO {

    @NotNull
    Long idCliente;

    @NotNull
    Long idFuncionario;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime diaAgendamento;

    @NotNull
    TipoServico servicoAgendar;

}
