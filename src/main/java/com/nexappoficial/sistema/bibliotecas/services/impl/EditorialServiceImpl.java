package com.nexappoficial.sistema.bibliotecas.services.impl;

import com.nexappoficial.sistema.bibliotecas.Utils.ErrorGenerico;
import com.nexappoficial.sistema.bibliotecas.dto.EditorialDto;
import com.nexappoficial.sistema.bibliotecas.entities.Editorial;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataDigitalizedException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataFoundException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoRecordsAvailable;
import com.nexappoficial.sistema.bibliotecas.repositories.EditorialRepository;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<EditorialDto> obtenerEditoriales() {
        List<Editorial> editoriales = (List<Editorial>) editorialRepository.findAll();
        List<EditorialDto> editorialesDto = editoriales.stream().map(EditorialDto::new).toList();

        if (ErrorGenerico.isNullOrEmpty(editorialesDto)) {
            throw new NoRecordsAvailable();
        }

        return editorialesDto;
    }

    @Override
    public EditorialDto obtenerEditorial(Long id) {
        EditorialDto editorialDto;
        Optional<Editorial> editorial = editorialRepository.findById(id);

        if (editorial.isPresent()) {
            editorialDto = new EditorialDto(editorial.get());
        } else {
            throw  new NoDataFoundException();
        }

        return editorialDto;
    }

    @Override
    public EditorialDto guardarEditorial(EditorialDto editorialDto) {
        String nombreEditorial = editorialDto.getNombre().trim();

        if (!(ErrorGenerico.isNullOrEmpty(nombreEditorial))) {
            Editorial editorial = new Editorial();
            editorial.setNombre(editorialDto.getNombre());
            editorial = editorialRepository.save(editorial);
            editorialDto = new EditorialDto(editorial);
        } else {
            throw new NoDataDigitalizedException();
        }

        return editorialDto;
    }

    @Override
    public void eliminarEditorial(Long id) {
        Optional<Editorial> editorial = editorialRepository.findById(id);

        if (editorial.isPresent()) {
            editorialRepository.deleteById(id);
        } else {
            throw  new NoDataFoundException();
        }
    }
}
