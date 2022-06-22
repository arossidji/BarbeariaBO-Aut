package com.br.barbeariabo.model.pessoa;

import com.br.barbeariabo.model.agenda.Agenda;
import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.servico.Servico;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String email;

    @OneToOne
    private Endereco endereco;

    @ManyToOne
    private Agenda agenda;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Servico> servicosUtilizado;







}
