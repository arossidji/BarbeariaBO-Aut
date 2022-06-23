package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.servico.Servico;
import com.br.barbeariabo.repository.ClienteRepository;
import com.br.barbeariabo.repository.FuncionarioRepository;
import com.br.barbeariabo.repository.ServicoRepository;
import com.br.barbeariabo.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public void cadastrarServico(ServicoDTO servicoDTO) {

        Servico servico = new Servico();

        Optional<Cliente> clienteOptional = clienteRepository.findById(servicoDTO.getClienteId());
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(servicoDTO.getFuncionarioId());

        servico.setDataServico(LocalDateTime.now());
        servico.setTipoServico(servicoDTO.getTipoServico());
        servico.setPreco(servicoDTO.getPreco());

        if (clienteOptional.isPresent() && funcionarioOptional.isPresent()) {
            servico.setCliente(clienteOptional.get());
            servico.setFuncionario(funcionarioOptional.get());
        }
        servicoRepository.save(servico);
    }

    @Override
    public void removerServico(Servico servico) {
        servicoRepository.delete(servico);
    }


    @Override
    public Page<ServicoDTO> listarServicos(Pageable pageable) {

        Page<Servico> list = servicoRepository.findAll(pageable);

        return list.map(item -> new ServicoDTO(item.getServicoId(),
                item.getFuncionario().getFuncionarioId(),
                item.getCliente().getClienteId(),
                item.getTipoServico(),
                item.getDataServico(),
                item.getPreco())
        );

    }

    @Override
    public Optional<Servico> findServicoById(Long id) {
        return servicoRepository.findById(id);
    }


}
