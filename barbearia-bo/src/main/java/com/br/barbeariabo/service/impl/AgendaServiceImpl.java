package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.repository.AgendaRepository;
import com.br.barbeariabo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    AgendaRepository repository;

    @Override
    public void cadastrarAgenda(Agenda agenda) {
        repository.save(agenda);
    }

    @Override
    public Optional<Agenda> findAgendaById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remover(Agenda agenda) {
        repository.delete(agenda);
    }


}
