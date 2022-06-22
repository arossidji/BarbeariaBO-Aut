package com.br.barbeariabo.service;

import com.br.barbeariabo.model.agenda.Agenda;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AgendaService {

    void cadastrarAgenda(Agenda agenda);

    Optional<Agenda> findAgendaById(Long id);

    void remover(Agenda agenda);

}
