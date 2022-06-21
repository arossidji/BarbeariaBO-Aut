package com.br.barbeariabo.repository;

import com.br.barbeariabo.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
