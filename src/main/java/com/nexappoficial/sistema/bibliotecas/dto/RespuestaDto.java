package com.nexappoficial.sistema.bibliotecas.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespuestaDto {

    private String mensaje;
    private int codigo;
    private Object data;

    public RespuestaDto() {

    }

    public RespuestaDto(String mensaje, int codigo, Object data) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.data = data;
    }
}
