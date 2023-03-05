package com.nexappoficial.sistema.bibliotecas.exceptiones;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;

public class NoRecordsAvailable extends RuntimeException {
    public NoRecordsAvailable() {
        super(Constante.ERROR_NO_EXISTEN_REGISTROS_DISPONIBLES);
    }
}
