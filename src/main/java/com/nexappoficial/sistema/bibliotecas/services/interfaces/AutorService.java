package com.nexappoficial.sistema.bibliotecas.services.interfaces;

import com.nexappoficial.sistema.bibliotecas.dto.AutorDto;

import java.util.List;

public interface AutorService {

    List<AutorDto> obtenerAutores();
    AutorDto obtenerAutor(Long id);
    AutorDto guardarAutor(AutorDto autor);
    void eliminarAutor(Long id);
}
