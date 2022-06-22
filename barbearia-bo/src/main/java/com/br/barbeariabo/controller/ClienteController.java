package com.br.barbeariabo.controller;

import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.service.ClienteService;
import com.br.barbeariabo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Object> cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        service.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente Cadastrado com Sucesso!");
    }

    @DeleteMapping("/removerCliente/{clienteId}")
    public ResponseEntity<Object> removerCliente(@PathVariable(value = "clienteId") Long id){
        Optional<Cliente> clienteOptional = service.findClienteById(id);
        if (clienteOptional.isPresent()){

            Optional<Endereco> enderecoOptional = enderecoService.findEnderecoById(clienteOptional.get().getEndereco().getEnderecoId());

            if (enderecoOptional.isPresent()) {
                service.remover(clienteOptional.get());
                enderecoService.remover(enderecoOptional.get());
                return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }

    @GetMapping("listarTodosClientes")
    public ResponseEntity<Page<Cliente>> listarTodosClientes(
            @PageableDefault(page = 0,size = 10, sort = "clienteId", direction = Sort.Direction.ASC) Pageable pageable){

        Page<Cliente> clientePage = service.listarTodosClientes(pageable);
        if (clientePage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clientePage);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientePage);
    }


}
