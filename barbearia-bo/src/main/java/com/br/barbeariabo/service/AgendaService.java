package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;


public interface AgendaService {

    void agendarServico(AgendamentoClienteDTO agenda) throws Exception;

}
