package com.br.barbeariabo.model.pessoa;

import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.servico.Servico;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @ManyToOne
    private Agenda agenda;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Servico> servicos;


}
