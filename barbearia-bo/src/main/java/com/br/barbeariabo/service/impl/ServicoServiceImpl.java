package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.enumerator.TipoServico;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.servico.Servico;
import com.br.barbeariabo.repository.ClienteRepository;
import com.br.barbeariabo.repository.FuncionarioRepository;
import com.br.barbeariabo.repository.ServicoRepository;
import com.br.barbeariabo.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Optional<Cliente> clienteOptional = clienteRepository.findById(servicoDTO.getCliente());
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(servicoDTO.getFuncionario());

        servico.setDataServico(servicoDTO.getDataServico());
        servico.setTipoServico(servicoDTO.getTipoServico());
        servico.setPreco(servicoDTO.getPreco());

        if (clienteOptional.isPresent() && funcionarioOptional.isPresent()){
            clienteOptional.get().getServicosUtilizado().add(servico);
            servico.setFuncionario(funcionarioOptional.get());
        }

        servicoRepository.save(servico);
    }

    @Override
    public void removerServico(Servico servico) {

    }
}
