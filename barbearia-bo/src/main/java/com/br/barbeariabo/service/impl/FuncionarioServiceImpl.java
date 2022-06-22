package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.repository.AgendaRepository;
import com.br.barbeariabo.repository.FuncionarioRepository;
import com.br.barbeariabo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Autowired
    AgendaRepository agendaRepository;

    @Override
    public void cadastrar(FuncionarioDTO func) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(func.getNome());
        funcionario.setDescrição(func.getDescricao());
        funcionario.setPosicao(func.getPosicao());
        funcionario.setTelefone(func.getTelefone());

        Agenda agendaFuncionario = new Agenda();
        funcionario.setAgenda(agendaFuncionario);

        agendaRepository.save(agendaFuncionario);
        repository.save(funcionario);

    }

    @Override
    public Optional<Funcionario> findFuncionarioById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remover(Funcionario func) {
        repository.delete(func);
    }

    @Override
    public Page<Funcionario> listarTodosFuncionarios(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
