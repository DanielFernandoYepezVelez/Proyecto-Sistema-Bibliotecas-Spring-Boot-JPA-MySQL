package com.nexappoficial.sistema.bibliotecas.repositories;

import com.nexappoficial.sistema.bibliotecas.entities.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Long> {
    Libro findBytitulo(String titulo);
}
