package com.br.barbeariabo.service.impl;

import com.br.barbeariabo.dto.UsuarioDTO;
import com.br.barbeariabo.exceptions.UsuarioException;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.usuario.Usuario;
import com.br.barbeariabo.repository.UsuarioRepository;
import com.br.barbeariabo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;


    @Override
    public void cadastrarUsuario(Funcionario funcionario, String login, String senha) {

        Usuario usuario = new Usuario();

        usuario.setLogin(login);
        usuario.setSenha(senha);

        repository.save(usuario);
        funcionario.setUsuario(usuario);
    }

    @Override
    public void atualizarSenha(UsuarioDTO usuarioDTO) throws UsuarioException {

        Optional<Usuario> usuarioOptional = repository.findByLogin(usuarioDTO.getLogin());
        if(!usuarioOptional.isPresent()){
            throw  new UsuarioException("Usuário não encontrado!");
        }
        if (usuarioOptional.get().getSenha() != null){
            if (usuarioOptional.get().getSenha().equalsIgnoreCase(usuarioDTO.getNovaSenha()))
                throw  new UsuarioException("Favor utilizar uma senha diferente das anteriores!");
        }

        usuarioOptional.get().setSenha(usuarioDTO.getNovaSenha());

        repository.save(usuarioOptional.get());
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return repository.findById(id);
    }


}
