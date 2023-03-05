package com.nexappoficial.sistema.bibliotecas.exceptiones;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;

public class NoDataDigitalizedException extends RuntimeException {

    public NoDataDigitalizedException() {
        super(Constante.ERROR_FALTA_DATO_OBIGATORIO);
    }

    public NoDataDigitalizedException(String message) {
        super(message);
    }
}
