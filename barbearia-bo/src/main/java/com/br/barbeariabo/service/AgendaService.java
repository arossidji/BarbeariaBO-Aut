package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.model.agenda.Agenda;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AgendaService {

    void agendarServico(AgendamentoClienteDTO agenda);

    Optional<Agenda> findAgendaById(Long id);

    void remover(Agenda agenda);

}
