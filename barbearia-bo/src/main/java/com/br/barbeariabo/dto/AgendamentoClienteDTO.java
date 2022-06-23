package com.br.barbeariabo.dto;

import com.br.barbeariabo.enumerator.TipoServico;

import java.time.LocalDateTime;

public class AgendamentoClienteDTO {

    Long idCliente;
    Long idFuncionario;
    LocalDateTime diaAgendamento;
    TipoServico servicoAgendar;

}
