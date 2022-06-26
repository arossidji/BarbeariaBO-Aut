package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.model.servico.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServicoService {

    void cadastrarServico(ServicoDTO servicoDTO);

    void removerServico(Servico servico);

    Page<ServicoDTO> listarServicos(Pageable pageable);

    Optional<Servico> findServicoById(Long id);

    List<String> listarTipoServicos();


}
