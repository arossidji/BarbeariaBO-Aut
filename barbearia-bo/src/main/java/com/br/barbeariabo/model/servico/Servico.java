package com.br.barbeariabo.model.servico;

import com.br.barbeariabo.enumerator.TipoServico;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoId;

    @OneToOne
    @JoinColumn(name = "funcionarioId")
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    private LocalDateTime dataServico;

    @ManyToOne
    private Cliente cliente;

    private Double preco;

}
