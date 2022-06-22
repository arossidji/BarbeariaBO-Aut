package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.model.servico.Servico;

public interface ServicoService {

    void cadastrarServico(ServicoDTO servicoDTO);

    void removerServico(Servico servico);


}
