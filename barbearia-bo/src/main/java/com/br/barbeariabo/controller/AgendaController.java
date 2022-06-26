package com.br.barbeariabo.controller;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.exceptions.ClienteException;
import com.br.barbeariabo.exceptions.FuncionarioException;
import com.br.barbeariabo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @PostMapping("/agendarCliente")
    public ResponseEntity<Object> agendarCliente(@RequestBody AgendamentoClienteDTO agendaDTO) throws ClienteException, FuncionarioException {
        agendaService.agendarServico(agendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Servico Agendado!");
    }

    @GetMapping("/listarAgendaCliente/{periodo}")
    public ResponseEntity<Object> agendarCliente(@PathVariable(value = "periodo") int periodo){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.filtrarAgenda(periodo));
    }


}
