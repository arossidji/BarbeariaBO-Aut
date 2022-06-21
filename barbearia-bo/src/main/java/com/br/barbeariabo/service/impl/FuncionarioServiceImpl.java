package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.repository.FuncionarioRepository;
import com.br.barbeariabo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Override
    public void cadastrar(FuncionarioDTO func) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(func.getNome());
        funcionario.setDescrição(func.getDescricao());
        funcionario.setPosicao(func.getPosicao());
        funcionario.setTelefone(func.getTelefone());

        repository.save(funcionario);

    }
}
