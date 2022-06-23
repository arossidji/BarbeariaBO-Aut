package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findServicoByCliente_ClienteId(Long id);

}
