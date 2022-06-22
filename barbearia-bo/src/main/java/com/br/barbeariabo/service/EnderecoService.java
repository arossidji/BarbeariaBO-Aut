package com.br.barbeariabo.service;

import com.br.barbeariabo.model.endereco.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EnderecoService {

    void cadastrarEndereco(Endereco endereco);

    Optional<Endereco> findEnderecoById(Long id);

    void remover(Endereco endereco);

    Page<Endereco> listarTodosEnderecos(Pageable pageable);

}
