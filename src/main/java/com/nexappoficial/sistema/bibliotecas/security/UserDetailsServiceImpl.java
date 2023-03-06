package com.nexappoficial.sistema.bibliotecas.security;

import com.nexappoficial.sistema.bibliotecas.entities.Usuario;
import com.nexappoficial.sistema.bibliotecas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* Es El Servicio Que Obtiene Un Usuario Desde La Base De Datos Y Haga Match Con El Que Se Loguea */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El Usuario Con Email: " + email + " No Existe."));

        // Retorno Una Implementacion De UserDetails (Es Decir, Debe Existir Una Clase Que La Implemente)
        return new UserDetailsImpl(usuario);
    }
}
