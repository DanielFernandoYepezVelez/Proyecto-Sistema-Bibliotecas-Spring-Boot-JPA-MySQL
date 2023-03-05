package com.nexappoficial.sistema.bibliotecas.services.impl;

import com.nexappoficial.sistema.bibliotecas.Utils.ErrorGenerico;
import com.nexappoficial.sistema.bibliotecas.dto.CategoriaDto;
import com.nexappoficial.sistema.bibliotecas.entities.Categoria;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataDigitalizedException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataFoundException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoRecordsAvailable;
import com.nexappoficial.sistema.bibliotecas.repositories.CategoriaRepository;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDto> obtenerCategorias() {
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
        List<CategoriaDto> categoriasDto = categorias.stream().map(CategoriaDto::new).toList();

        if (ErrorGenerico.isNullOrEmpty(categoriasDto)) {
            throw new NoRecordsAvailable();
        }

        return categoriasDto;
    }

    @Override
    public CategoriaDto obtenerCategoria(Long id) {
        CategoriaDto categoriaDto;
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            categoriaDto = new CategoriaDto(categoria.get());
        } else {
            throw new NoDataFoundException();
        }

        return categoriaDto;
    }

    @Override
    public CategoriaDto guardarCategoria(CategoriaDto categoriaDto) {
        String nombreCategoria = categoriaDto.getNombre().trim();

        if(!(ErrorGenerico.isNullOrEmpty(nombreCategoria))) {
            Categoria categoria = new Categoria();
            categoria.setNombre(categoriaDto.getNombre());
            categoria = categoriaRepository.save(categoria);
            categoriaDto = new CategoriaDto(categoria);
        } else {
            throw new NoDataDigitalizedException();
        }

        return categoriaDto;
    }

    @Override
    public void eliminarCategoria(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
        } else {
            throw  new NoDataFoundException();
        }
    }

}
