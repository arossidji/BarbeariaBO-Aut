package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.RelatorioServFuncionarioDTO;
import com.br.barbeariabo.repository.ServicoRepository;
import com.br.barbeariabo.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Autowired
    ServicoRepository repository;

    @Override
    public List<RelatorioServFuncionarioDTO> listarRelatorio() {
        return repository.relatorioQtdeServicoAgendadoFunc();
    }
}
