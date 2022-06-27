package com.br.barbeariabo.resources;

import com.br.barbeariabo.dto.FuncionarioDTO;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.br.barbeariabo.service.AgendaService;
import com.br.barbeariabo.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @Autowired
    AgendaService agendaService;

    @PostMapping("/cadastrarFuncionario")
    public ResponseEntity<Object> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario){

        // se ja existir um funcionario com este nome enviar conflito.
        service.cadastrar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario Cadastrado com Sucesso");

    }


    @DeleteMapping("/removerFuncionario/{funcionarioId}")
    public ResponseEntity<Object> removerFuncionario(@PathVariable(value = "funcionarioId") Long id){
        Optional<Funcionario> funcionarioOptional = service.findFuncionarioById(id);

        if (funcionarioOptional.isPresent()){
                service.remover(funcionarioOptional.get());
                return ResponseEntity.status(HttpStatus.OK).body("Funcionario Excluido e agenda esvaziada!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado!");
    }



    @GetMapping("listarTodosFuncionarios")
    public ResponseEntity<Page<Funcionario>> listarTodosFuncionarios(
            @PageableDefault(page = 0,size = 10, sort = "funcionarioId", direction = Sort.Direction.ASC) Pageable pageable){

        Page<Funcionario> funcionarioPage = service.listarTodosFuncionarios(pageable);
        if (funcionarioPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(funcionarioPage);
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioPage);
    }

}
