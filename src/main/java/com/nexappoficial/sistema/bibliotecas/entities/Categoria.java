package com.nexappoficial.sistema.bibliotecas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "categorias", schema = "generico")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    private String nombre;

    //@JsonIgnoreProperties({"categoria"})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "categoria"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Categoria() {
        libros = new ArrayList<>();
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
