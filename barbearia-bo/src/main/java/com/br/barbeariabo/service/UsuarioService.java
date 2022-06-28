package com.br.barbeariabo.service;

import com.br.barbeariabo.dto.UsuarioDTO;
import com.br.barbeariabo.exceptions.UsuarioException;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    void cadastrarUsuario(Funcionario funcionario, String login, String senha);

    void atualizarSenha(UsuarioDTO usuarioDTO) throws UsuarioException;

    List<Usuario> listarTodosUsuarios();

    Optional<Usuario> findUsuarioById(Long id);
}
