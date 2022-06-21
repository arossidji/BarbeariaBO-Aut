package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.pessoa.Funcionario;
import org.springframework.stereotype.Component;


public interface FuncionarioService {

    void cadastrar(FuncionarioDTO func);

}
