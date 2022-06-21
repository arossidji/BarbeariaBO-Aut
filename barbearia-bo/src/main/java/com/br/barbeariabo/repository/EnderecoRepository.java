package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
