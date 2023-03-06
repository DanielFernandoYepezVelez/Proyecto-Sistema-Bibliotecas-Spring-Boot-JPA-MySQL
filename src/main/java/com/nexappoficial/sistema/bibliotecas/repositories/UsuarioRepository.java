package com.nexappoficial.sistema.bibliotecas.repositories;

import com.nexappoficial.sistema.bibliotecas.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);
}
