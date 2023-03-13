package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.Autor;
import com.nexappoficial.sistema.bibliotecas.entities.Categoria;
import com.nexappoficial.sistema.bibliotecas.entities.Editorial;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibroDto {
    private Long id;

    private String titulo;

    private String descripcion;

    private String favorito;

    private Categoria categoria;

    private Editorial editorial;

    private List<Autor> autores;

    public LibroDto() {
        // TODO document why this constructor is empty
    }

    public LibroDto(Long id, String titulo, String descripcion,
                    String favorito, Categoria categoria,
                    Editorial editorial, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.favorito = favorito;
        this.categoria = categoria;
        this.editorial = editorial;
        this.autores = autores;
    }

    public LibroDto(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.descripcion = libro.getDescripcion();
        this.favorito = libro.getFavorito();
        this.categoria = libro.getCategoria();
        this.editorial = libro.getEditorial();
        this.autores = libro.getAutores();
    }
}
