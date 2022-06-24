package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoClienteDTO {

    Long idCliente;
    Long idFuncionario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime diaAgendamento;
    TipoServico servicoAgendar;

}
