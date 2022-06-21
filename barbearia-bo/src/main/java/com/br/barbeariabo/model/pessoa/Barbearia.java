package com.br.barbeariabo.model.pessoa;

import com.br.barbeariabo.model.endereco.Endereco;
import com.br.barbeariabo.model.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_barbearia")
public class Barbearia extends PessoaJuridica{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long barbeariaId;

    @OneToOne
    private Endereco endereco;

    private String telefone;

    @OneToMany(mappedBy = "barbearia")
    private List<Funcionario> funcionarios;

}
