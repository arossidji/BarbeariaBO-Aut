package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.pessoa.Barbearia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
}
