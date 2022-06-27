package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.AgendaRetornoDTO;
import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.exceptions.ClienteException;
import com.br.barbeariabo.exceptions.FuncionarioException;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.servico.Servico;
import com.br.barbeariabo.repository.ServicoRepository;
import com.br.barbeariabo.service.AgendaService;
import com.br.barbeariabo.service.ClienteService;
import com.br.barbeariabo.service.FuncionarioService;
import com.br.barbeariabo.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    ServicoService servicoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ServicoRepository servicoRepository;

    @Override
    public void agendarServico(AgendamentoClienteDTO agenda) throws ClienteException, FuncionarioException {
         Optional<Cliente> clienteOptional = clienteService.findClienteById(agenda.getIdCliente());
        Optional<Funcionario> funcionarioOptional = funcionarioService.findFuncionarioById(agenda.getIdFuncionario());
        if (!clienteOptional.isPresent())
            throw new ClienteException();
        if (!funcionarioOptional.isPresent())
            throw new FuncionarioException();

        servicoService.cadastrarServico(montarServicoAgendamento(agenda));
    }

    @Override
    public List<AgendaRetornoDTO> filtrarAgenda(int periodo) {

        switch (periodo){
            case 1:
               return listarAgendaPorDia();
            case 7:
                return listarAgendaPorSemana();
            case  30:
                return listarAgendaPorMes();
            case 365:
                return listarAgendaPorAno();
        }
        return null;
    }

    private List<AgendaRetornoDTO> listarAgendaPorDia(){
        LocalDateTime dia = LocalDateTime.now();
        LocalDateTime dtInicio = dia.toLocalDate().atTime(LocalTime.MIN);
        LocalDateTime dtFim = dia.toLocalDate().atTime(LocalTime.MAX);

        return obterDadosAgendamentos(dtInicio,dtFim);
    }

    private List<AgendaRetornoDTO> listarAgendaPorSemana(){
        LocalDate dia = LocalDate.now();
        LocalDate inicio = dia.with(DayOfWeek.MONDAY);
        LocalDate fim = dia.with(DayOfWeek.SUNDAY);

        LocalDateTime dtInicio = inicio.atTime(00,00,00);
        LocalDateTime dtFim = fim.atTime(23,59,59);

        return obterDadosAgendamentos(dtInicio,dtFim);
    };
    private List<AgendaRetornoDTO> listarAgendaPorMes(){
        LocalDate dia = LocalDate.now();
        LocalDate inicio = dia.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate fim = dia.with(TemporalAdjusters.lastDayOfMonth());

        LocalDateTime dtInicio = inicio.atTime(00,00,00);
        LocalDateTime dtFim = fim.atTime(23,59,59);

        return obterDadosAgendamentos(dtInicio,dtFim);

    };
    private List<AgendaRetornoDTO> listarAgendaPorAno(){
        LocalDate dia = LocalDate.now();
        LocalDate inicio = dia.with(TemporalAdjusters.firstDayOfYear());
        LocalDate fim = dia.with(TemporalAdjusters.lastDayOfYear());

        LocalDateTime dtInicio = inicio.atTime(00,00,00);
        LocalDateTime dtFim = fim.atTime(23,59,59);

        return obterDadosAgendamentos(dtInicio,dtFim);
    };

    private List<AgendaRetornoDTO> obterDadosAgendamentos(LocalDateTime dtInicio, LocalDateTime dtFim){
        List<Servico> servicos = servicoRepository.obterAgendaServicoPorPeriodo(dtInicio,dtFim);
        if (servicos.isEmpty()){
            List<AgendaRetornoDTO> listaAgenda = new ArrayList<AgendaRetornoDTO>();
            return listaAgenda;
        }
        return servicos.stream().map(servico -> new AgendaRetornoDTO(servico.getFuncionario().getNome(),
                        servico.getCliente().getNome(),
                        servico.getTipoServico().getDescription(),
                        servico.getDataServico()
                )
        ).collect(Collectors.toList());
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
