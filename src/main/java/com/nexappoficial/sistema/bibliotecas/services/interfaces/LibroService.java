package com.nexappoficial.sistema.bibliotecas.services.interfaces;

import com.nexappoficial.sistema.bibliotecas.dto.LibroDto;

import java.util.List;

public interface LibroService {

    List<LibroDto> obtenerLibros();
    LibroDto obtenerLibro(Long id);
    LibroDto guardarLibro(LibroDto libroDto);
    void eliminarLibro(Long id);
    LibroDto libroPorTitulo(String titulo);

}
