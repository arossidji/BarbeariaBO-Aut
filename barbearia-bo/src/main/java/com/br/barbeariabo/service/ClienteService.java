package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {

    void cadastrarCliente(ClienteDTO cliente);

    Optional<Cliente> findClienteById(Long id);

    void remover(Cliente cliente);

    Page<Cliente> listarTodosClientes(Pageable pageable);

}
