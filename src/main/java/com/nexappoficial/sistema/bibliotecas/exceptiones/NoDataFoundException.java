package com.nexappoficial.sistema.bibliotecas.exceptiones;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super(Constante.MSG_REGISTRO_NO_ENCONTRADO);
    }
}
