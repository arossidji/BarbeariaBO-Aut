package com.br.barbeariabo.model.servico;

import com.br.barbeariabo.enumerator.TipoServico;
import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID servicoId;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    private Double preco;
    boolean isConcluido;

}
