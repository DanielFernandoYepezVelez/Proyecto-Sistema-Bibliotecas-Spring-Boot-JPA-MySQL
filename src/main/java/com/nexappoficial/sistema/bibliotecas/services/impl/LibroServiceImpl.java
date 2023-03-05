package com.nexappoficial.sistema.bibliotecas.services.impl;

import com.nexappoficial.sistema.bibliotecas.Utils.ErrorGenerico;
import com.nexappoficial.sistema.bibliotecas.dto.LibroDto;
import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataDigitalizedException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataFoundException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoRecordsAvailable;
import com.nexappoficial.sistema.bibliotecas.repositories.LibroRepository;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<LibroDto> obtenerLibros() {
        List<LibroDto> librosDto;
        List<Libro> libros = (List<Libro>) libroRepository.findAll();

        if (!(ErrorGenerico.isNullOrEmpty(libros))) {
            librosDto = libros.stream().map(LibroDto::new).toList();
        } else {
            throw  new NoRecordsAvailable();
        }

        return librosDto;
    }

    @Override
    public LibroDto obtenerLibro(Long id) {
        LibroDto libroDto;
        Optional<Libro> libro = libroRepository.findById(id);

        if (libro.isPresent()) {
            libroDto = new LibroDto(libro.get());
        } else {
            throw new NoDataFoundException();
        }

        return libroDto;
    }

    @Override
    public LibroDto guardarLibro(LibroDto libroDto) {
        LibroDto libroRespDto1;
        List<LibroDto> librosDto = new ArrayList<>();

        librosDto.add(libroDto);

        /*boolean data = librosDto.stream().map(libroDto1 ->
                libroDto1.getTitulo().trim().equalsIgnoreCase("") ||
                libroDto1.getDescripcion().trim().equalsIgnoreCase("") ||
                libroDto1.getFavorito().trim().equalsIgnoreCase("") ||
                libroDto1.getCategoria() == null || libroDto1.getEditorial() == null).equals(true); */

        if (false) {
            throw  new NoDataDigitalizedException();
        } else {
            Libro libro = new Libro();

            libro.setTitulo(libroDto.getTitulo());
            libro.setDescripcion(libroDto.getDescripcion());
            libro.setFavorito(libroDto.getFavorito());
            libro.setCategoria(libroDto.getCategoria());
            libro.setEditorial(libroDto.getEditorial());
            libro.setAutores(libroDto.getAutores());

            Libro libro1 = libroRepository.save(libro);
            libroRespDto1 = new LibroDto(libro1);
        }

        return libroRespDto1;
    }

    @Override
    public void eliminarLibro(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);

        if (libro.isPresent()) {
            libroRepository.deleteById(id);
        } else {
            throw new NoDataFoundException();
        }
    }

    @Override
    public LibroDto libroPorTitulo(String titulo) {
        return null;
    }


}
