package com.br.barbeariabo.controller;

import com.br.barbeariabo.dto.AgendamentoClienteDTO;
import com.br.barbeariabo.dto.ClienteDTO;
import com.br.barbeariabo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendar")
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @PostMapping("/agendarCliente")
    public ResponseEntity<Object> agendarCliente(@RequestBody AgendamentoClienteDTO agendaDTO) throws Exception {
        agendaService.agendarServico(agendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Servico Agendado!");
    }

}
