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
@Table(name = "autores", schema = "generico")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long id;

    private String nombre;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "autores"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /* Aquí Estamos Customizando O Personalizando La Tabla Intermedia De Muchos A Muchos Que Resulto De La Relación */
    @JoinTable(name = "autores_libros",
               joinColumns = @JoinColumn(name = "id_autor"),
               inverseJoinColumns = @JoinColumn(name = "id_libro"),
               uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"id_autor", "id_libro"})
               })
    private List<Libro> libros;

    public Autor() {
        this.libros = new ArrayList<>();
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
