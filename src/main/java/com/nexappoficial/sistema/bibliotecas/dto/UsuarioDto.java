package com.nexappoficial.sistema.bibliotecas.dto;

import com.nexappoficial.sistema.bibliotecas.entities.Role;
import com.nexappoficial.sistema.bibliotecas.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Role> roles;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String username, String email, String password, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.password = getUsername();
    }
}
