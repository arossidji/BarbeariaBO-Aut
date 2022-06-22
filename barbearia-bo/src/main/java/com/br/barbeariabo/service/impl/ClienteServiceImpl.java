package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.repository.ClienteRepository;
import com.br.barbeariabo.repository.EnderecoRepository;
import com.br.barbeariabo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public void cadastrarCliente(ClienteDTO cliente) {

        Cliente clienteModel = new Cliente();
        Endereco enderecoModel = new Endereco();

        clienteModel.setNome(cliente.getNomeCompleto());
        clienteModel.setEmail(cliente.getEmail());
        clienteModel.setTelefone(cliente.getTelefone());

        enderecoModel.setBairro(cliente.getBairro());
        enderecoModel.setCidade(cliente.getCidade());
        enderecoModel.setNumero(cliente.getNumero());
        enderecoModel.setRua(cliente.getRua());
        enderecoModel.setUf(cliente.getUf());

        clienteModel.setEndereco(enderecoModel);

        enderecoRepository.save(enderecoModel);
        repository.save(clienteModel);
    }

    @Override
    public Optional<Cliente> findClienteById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remover(Cliente cliente) {
        repository.delete(cliente);
    }

    @Override
    public Page<Cliente> listarTodosClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
