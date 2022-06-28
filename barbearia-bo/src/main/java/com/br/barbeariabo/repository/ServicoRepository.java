package com.br.barbeariabo.repository;

import com.br.barbeariabo.dto.RelatorioServFuncionarioDTO;
import com.br.barbeariabo.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;



public interface ServicoRepository extends JpaRepository<Servico, Long> {


    @Query(value = "select s from Servico s where s.dataServico >= :dtInicio and s.dataServico <= :dtFinal")
    List<Servico> obterAgendaServicoPorPeriodo(@Param("dtInicio")LocalDateTime dtInicio, @Param("dtFinal") LocalDateTime dtFinal);

    @Query(value = "select new com.br.barbeariabo.dto.RelatorioServFuncionarioDTO (f.funcionarioId,f.nome,count (s.servicoId),CURRENT_DATE ) " +
            "from Servico s " +
            "inner join Funcionario f on s.funcionario.funcionarioId = f.funcionarioId " +
            "where function('month',s.dataServico) = function('month',current_date ) " +
            "and function('year', s.dataServico) = function('year', current_date ) " +
            "and s.isAgendado = true " +
            "group by  f.funcionarioId,f.nome")
    List<RelatorioServFuncionarioDTO> relatorioQtdeServicoAgendadoFunc();

}

