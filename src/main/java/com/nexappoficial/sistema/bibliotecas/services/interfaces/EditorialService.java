package com.nexappoficial.sistema.bibliotecas.services.interfaces;

import com.nexappoficial.sistema.bibliotecas.dto.EditorialDto;

import java.util.List;

public interface EditorialService {

    List<EditorialDto> obtenerEditoriales();
    EditorialDto obtenerEditorial(Long id);
    EditorialDto guardarEditorial(EditorialDto editorialDto);
    void eliminarEditorial(Long id);

}
