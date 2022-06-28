package com.br.barbeariabo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RelatorioServFuncionarioDTO {

   // "Relatorio Quantidade de Servico Agendado por Funcionario no mês";

    public Long idFuncionario;

    public String nomeFuncionario;

    public Long qtdeServicoAgendado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    public Date mesAnoAtual;

}
