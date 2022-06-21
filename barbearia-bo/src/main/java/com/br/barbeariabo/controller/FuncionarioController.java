package com.br.barbeariabo.controller;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @PostMapping("/cadastrar")
    ResponseEntity<Object> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario){

        // se ja existir um funcionario com este nome enviar conflito.
        service.cadastrar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario Cadastrado com Sucesso");

    }

}
