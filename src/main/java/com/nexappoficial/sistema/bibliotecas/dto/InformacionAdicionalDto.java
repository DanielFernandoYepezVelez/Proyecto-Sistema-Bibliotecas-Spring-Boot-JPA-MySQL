package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.InformacionAdicional;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformacionAdicionalDto {
    private Long id;

    private String idioma;

    private String fechaPublicacion;

    private Libro libro;

    public InformacionAdicionalDto() {
    }

    public InformacionAdicionalDto(Long id, String idioma, String fechaPublicacion, Libro libro) {
        this.id = id;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicacion;
        this.libro = libro;
    }

    public InformacionAdicionalDto(InformacionAdicional informacionAdicional) {
        this.id = informacionAdicional.getId();
        this.idioma = informacionAdicional.getIdioma();
        this.fechaPublicacion = informacionAdicional.getFechaPublicacion();
        this.libro = informacionAdicional.getLibro();
    }
}
