package com.nexappoficial.sistema.bibliotecas.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "roles", schema = "generico")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    private Erole nombre;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Role() {
        // TODO document why this constructor is empty
    }
}
