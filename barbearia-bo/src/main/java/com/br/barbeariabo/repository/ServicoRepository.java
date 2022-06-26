package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;



public interface ServicoRepository extends JpaRepository<Servico, Long> {


    @Query(value = "select s from Servico s where s.dataServico >= :dtInicio and s.dataServico <= :dtFinal")
    List<Servico> obterAgendaServicoPorPeriodo(@Param("dtInicio")LocalDateTime dtInicio, @Param("dtFinal") LocalDateTime dtFinal);

}

