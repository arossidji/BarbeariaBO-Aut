package com.br.barbeariabo.model.pessoa;

import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funcionarioId;

    private String posicao;

    private String descrição;

    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private Agenda agenda;

    @ManyToOne
    private Barbearia barbearia;

}
