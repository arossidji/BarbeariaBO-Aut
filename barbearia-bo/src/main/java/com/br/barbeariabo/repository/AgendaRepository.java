package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.agenda.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
