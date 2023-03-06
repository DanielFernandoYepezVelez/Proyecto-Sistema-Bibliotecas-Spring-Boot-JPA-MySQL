package com.nexappoficial.sistema.bibliotecas.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "usuarios", schema = "generico")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String username;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
               joinColumns = @JoinColumn(name = "id_usuario"),
               inverseJoinColumns = @JoinColumn(name = "id_role"),
               uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario", "id_role"})}
    )
    private List<Role> roles;

    public Usuario() {
        this.roles = new ArrayList<>();
    }
}
