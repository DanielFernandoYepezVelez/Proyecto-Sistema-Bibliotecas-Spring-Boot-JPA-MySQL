package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.Autor;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutorDto {
    private Long id;

    private String nombre;

    private List<Libro> libros;

    public AutorDto() {
    }

    public AutorDto(Long id, String nombre, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.libros = libros;
    }

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.libros = autor.getLibros();
    }
}
