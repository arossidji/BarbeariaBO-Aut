package com.br.barbeariabo.controller;

import com.br.barbeariabo.dto.ServicoDTO;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.servico.Servico;
import com.br.barbeariabo.service.ServicoService;
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
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    ServicoService servicoService;


    @PostMapping("/cadastrarServico")
    public ResponseEntity<Object> vincularServico(@RequestBody ServicoDTO servicoDTO){
        // se ja existir um funcionario com este nome enviar conflito.
        servicoService.cadastrarServico(servicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Servico cadastrado com Sucesso");
    }


    @GetMapping("listarTodosServicos")
    public ResponseEntity<Page<ServicoDTO>> listarTodosServicos(
            @PageableDefault(page = 0,size = 10, sort = "servicoId", direction = Sort.Direction.ASC) Pageable pageable){

        Page<ServicoDTO> servicoPage = servicoService.listarServicos(pageable);
        if (servicoPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(servicoPage);
        }

        return ResponseEntity.status(HttpStatus.OK).body(servicoPage);
    }


    @DeleteMapping("/removerServico/{servicoId}")
    public ResponseEntity<Object> removerServico(@PathVariable(value = "servicoId") Long id){
        Optional<Servico> servicoOptional = servicoService.findServicoById(id);
        if (servicoOptional.isPresent()){
            servicoService.removerServico(servicoOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Servico removido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico não encontrado!");
    }


}
