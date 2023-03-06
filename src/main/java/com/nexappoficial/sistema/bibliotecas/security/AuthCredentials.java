package com.nexappoficial.sistema.bibliotecas.security;

import lombok.Data;

/* Esta Clase Recibe De La Base De Datos Un Usuario Con Sus Respectivas Propiedades */
@Data
public class AuthCredentials {
    private String username;
    private String email;
    private String password;
}
