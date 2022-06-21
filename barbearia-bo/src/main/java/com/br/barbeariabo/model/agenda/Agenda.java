package com.br.barbeariabo.model.agenda;

import com.br.barbeariabo.model.pessoa.Cliente;
import com.br.barbeariabo.model.pessoa.Funcionario;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID agendaId;

    private Date data;

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;

}
