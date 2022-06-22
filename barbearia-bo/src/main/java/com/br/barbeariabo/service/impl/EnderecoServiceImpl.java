package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.repository.EnderecoRepository;
import com.br.barbeariabo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

   @Autowired
   EnderecoRepository repository;


    @Override
    public void cadastrarEndereco(Endereco endereco) {
        repository.save(endereco);
    }

    @Override
    public Optional<Endereco> findEnderecoById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remover(Endereco endereco) {
        repository.delete(endereco);
    }

    @Override
    public Page<Endereco> listarTodosEnderecos(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
