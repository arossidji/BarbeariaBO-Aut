package com.br.barbeariabo.resources;

import com.br.barbeariabo.dto.UsuarioDTO;
import com.br.barbeariabo.exceptions.UsuarioException;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.model.usuario.Usuario;
import com.br.barbeariabo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PutMapping("atualizarSenha")
    public ResponseEntity<Object> atualizarSenhaUsuario(@RequestBody UsuarioDTO usuarioDTO) throws UsuarioException {

            usuarioService.atualizarSenha(usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso!");

    }

    @GetMapping("listarTodosUsuarios")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios(){

        List<Usuario> listUsuarios = usuarioService.listarTodosUsuarios();
        if (listUsuarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listUsuarios);
        }
        return ResponseEntity.status(HttpStatus.OK).body(listUsuarios);
    }


}
