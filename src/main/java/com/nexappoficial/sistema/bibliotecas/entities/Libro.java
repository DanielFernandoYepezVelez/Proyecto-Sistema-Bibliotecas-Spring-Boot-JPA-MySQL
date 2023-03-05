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
@Table(name = "libros", schema = "generico")
@Getter
@Setter
@EqualsAndHashCode
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    private String titulo;

    private String descripcion;

    private String favorito;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
    @ManyToMany(mappedBy = "libros", cascade = CascadeType.ALL)
    private List<Autor> autores;

    public Libro() {
        this.autores = new ArrayList<>();
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
