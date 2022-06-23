package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.servico.Servico;
import com.br.barbeariabo.repository.ClienteRepository;
import com.br.barbeariabo.repository.EnderecoRepository;
import com.br.barbeariabo.repository.ServicoRepository;
import com.br.barbeariabo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ServicoRepository servicoRepository;

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
    public Page<ClienteDTO> listarTodosClientes(Pageable pageable) {

        Page<Cliente> list = repository.findAll(pageable);

        return list.map(item -> new ClienteDTO(item.getNome(),
                item.getEmail(),
                item.getEndereco().getRua(),
                item.getEndereco().getBairro(),
                item.getEndereco().getNumero(),
                item.getEndereco().getCidade(),
                item.getEndereco().getUf(),
                item.getTelefone()
             )
        );
    }



    /*
    private List<ServicoDTO> listarServicoPorCliente(Long clienteId){

        List<Servico> listaServicos = servicoRepository.findServicoByCliente_ClienteId(clienteId);

        return listaServicos
                .stream()
                .map(item -> new ServicoDTO(item.getServicoId(),
                                item.getFuncionario().getFuncionarioId(),
                                item.getCliente().getClienteId(),
                                item.getTipoServico(),
                                item.getDataServico(),
                                item.getPreco()))
                .collect(Collectors.toList());
    }
    */




}
