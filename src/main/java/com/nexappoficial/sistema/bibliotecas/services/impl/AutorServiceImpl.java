package com.nexappoficial.sistema.bibliotecas.services.impl;

import com.nexappoficial.sistema.bibliotecas.Utils.ErrorGenerico;
import com.nexappoficial.sistema.bibliotecas.dto.AutorDto;
import com.nexappoficial.sistema.bibliotecas.entities.Autor;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataDigitalizedException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataFoundException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoRecordsAvailable;
import com.nexappoficial.sistema.bibliotecas.repositories.AutorRepository;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorDto> obtenerAutores() {
        List<Autor> autores = (List<Autor>) autorRepository.findAll();
        List<AutorDto> autoresDto = autores.stream().map(AutorDto::new).toList();

        if (ErrorGenerico.isNullOrEmpty(autoresDto)) {
            throw new NoRecordsAvailable();
        }

        return autoresDto;
    }

    @Override
    public AutorDto obtenerAutor(Long id) {
        AutorDto autorDto;
        Optional<Autor> autor = autorRepository.findById(id);

        if (autor.isPresent()) {
            autorDto = new AutorDto(autor.get());
        } else {
            throw new NoDataFoundException();
        }

        return autorDto;
    }

    @Override
    public AutorDto guardarAutor(AutorDto autorDto) {
        String nombreAutor = autorDto.getNombre().trim();

        if(!(ErrorGenerico.isNullOrEmpty(nombreAutor))) {
            Autor autor = new Autor();
            autor.setNombre(autorDto.getNombre());
            autor.setLibros(autorDto.getLibros());

            autor = autorRepository.save(autor);
            autorDto = new AutorDto(autor);
        } else {
            throw new NoDataDigitalizedException();
        }

        return autorDto;
    }

    @Override
    public void eliminarAutor(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);

        if(autor.isPresent()) {
            autorRepository.deleteById(id);
        } else {
            throw new NoDataFoundException();
        }
    }
}
