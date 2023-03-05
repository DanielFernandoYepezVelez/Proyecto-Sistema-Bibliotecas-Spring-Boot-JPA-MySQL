package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.Editorial;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditorialDto {

    private Long id;

    private String nombre;

    private List<Libro> libros;

    public EditorialDto() {
    }

    public EditorialDto(Long id, String nombre, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.libros = libros;
    }

    public EditorialDto(Editorial editorial) {
        this.id = editorial.getId();
        this.nombre = editorial.getNombre();
        this.libros = editorial.getLibros();
    }

}