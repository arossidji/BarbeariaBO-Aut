package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.pessoa.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
