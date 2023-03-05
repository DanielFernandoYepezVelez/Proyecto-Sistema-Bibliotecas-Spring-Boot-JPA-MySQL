package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.Categoria;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaDto {

    private Long id;

    private String nombre;

    private List<Libro> libros;

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String nombre, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.libros = libros;
    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
        this.libros = categoria.getLibros();
    }
}