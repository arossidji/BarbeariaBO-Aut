package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.AgendaRetornoDTO;
import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.exceptions.ClienteException;
import com.br.barbeariabo.exceptions.FuncionarioException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendaService {

    void agendarServico(AgendamentoClienteDTO agenda) throws ClienteException, FuncionarioException;

    List<AgendaRetornoDTO> filtrarAgenda(int periodo);

}
