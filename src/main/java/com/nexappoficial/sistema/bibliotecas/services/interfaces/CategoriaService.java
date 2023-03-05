package com.nexappoficial.sistema.bibliotecas.services.interfaces;

import com.nexappoficial.sistema.bibliotecas.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDto> obtenerCategorias();
    CategoriaDto obtenerCategoria(Long id);
    CategoriaDto guardarCategoria(CategoriaDto categoria);
    void eliminarCategoria(Long id);

}
