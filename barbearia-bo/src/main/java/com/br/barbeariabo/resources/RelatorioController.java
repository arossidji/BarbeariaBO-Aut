package com.br.barbeariabo.resources;

import com.br.barbeariabo.dto.RelatorioServFuncionarioDTO;
import com.br.barbeariabo.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;


    @GetMapping("/servicoAgendadoPorFuncionario")
    public ResponseEntity<Object> listarRelatorio(){

        List<RelatorioServFuncionarioDTO> relatorioFuncionario = relatorioService.listarRelatorio();

        Map<String, List<RelatorioServFuncionarioDTO>> mapRelatorio = new HashMap<>();

        String nomeRelatorio= "Relatorio Quantidade de Servico Agendado por Funcionario no mês ATUAL!";
        mapRelatorio.put(nomeRelatorio, relatorioFuncionario);

        return ResponseEntity.status(HttpStatus.OK).body(mapRelatorio);
    };

}
