package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.pessoa.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
