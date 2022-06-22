package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.pessoa.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface FuncionarioService {

    void cadastrar(FuncionarioDTO func);

    Optional<Funcionario> findFuncionarioById(Long id);

    void remover(Funcionario func);

    Page<Funcionario> listarTodosFuncionarios(Pageable pageable);


}
