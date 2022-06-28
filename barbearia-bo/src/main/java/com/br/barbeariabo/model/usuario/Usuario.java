package com.br.barbeariabo.model.usuario;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @Column(length = 80,nullable = false)
    private String nome;
    @Column(length = 20,unique = true,nullable = false)
    private String login;
    @Column(length = 100, nullable = false)
    private String senha;
    private boolean admin;

    public List<String> getRoles(){
        ArrayList<String> roles = new ArrayList<>();
        roles.add("USER");
        if (admin){
            roles.add("ADMIN");
        }
        return roles;
    }

    public List<SimpleGrantedAuthority> getRolesAuthority(){
        ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add( new SimpleGrantedAuthority("USER"));
        if (admin){
            roles.add( new SimpleGrantedAuthority("ADMIN") );
        }
        return roles;
    }

}
