package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.exceptions.ClienteException;
import com.br.barbeariabo.exceptions.FuncionarioException;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.service.AgendaService;
import com.br.barbeariabo.service.ClienteService;
import com.br.barbeariabo.service.FuncionarioService;
import com.br.barbeariabo.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    ServicoService servicoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    FuncionarioService funcionarioService;

    @Override
    public void agendarServico(AgendamentoClienteDTO agenda) throws Exception, ClienteException, FuncionarioException {
         Optional<Cliente> clienteOptional = clienteService.findClienteById(agenda.getIdCliente());
        Optional<Funcionario> funcionarioOptional = funcionarioService.findFuncionarioById(agenda.getIdFuncionario());
        if (!clienteOptional.isPresent())
            throw new ClienteException();
        if (!funcionarioOptional.isPresent())
            throw new FuncionarioException();

        servicoService.cadastrarServico(montarServicoAgendamento(agenda));
    }

    private ServicoDTO montarServicoAgendamento(AgendamentoClienteDTO agenda){
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setFuncionarioId(agenda.getIdFuncionario());
        servicoDTO.setClienteId(agenda.getIdCliente());
        servicoDTO.setTipoServico(agenda.getServicoAgendar());
        servicoDTO.setDataServico(agenda.getDiaAgendamento());

        return servicoDTO;
    }

}
