package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.repository.AgendaRepository;
import com.br.barbeariabo.service.AgendaService;
import com.br.barbeariabo.service.ClienteService;
import com.br.barbeariabo.service.FuncionarioService;
import com.br.barbeariabo.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    @Autowired
    ServicoService servicoService;

    @Autowired
    ClienteService clienteServiceservice;

    @Autowired
    FuncionarioService funcionarioService;

    @Override
    public void agendarServico(AgendamentoClienteDTO agenda) {





    }

    @Override
    public Optional<Agenda> findAgendaById(Long id) {
        return agendaRepository.findById(id);
    }

    @Override
    public void remover(Agenda agenda) {
        agendaRepository.delete(agenda);
    }


}
