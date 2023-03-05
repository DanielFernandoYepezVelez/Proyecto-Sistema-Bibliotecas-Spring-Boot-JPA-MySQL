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
@Table(name = "editoriales", schema = "generico")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Long id;

    private String nombre;

    //@JsonIgnoreProperties({"editorial"})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "editorial"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Editorial() {
        libros = new ArrayList<>();
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
