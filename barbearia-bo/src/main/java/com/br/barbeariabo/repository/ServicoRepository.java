package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
