package com.nexappoficial.sistema.bibliotecas.services.interfaces;

import com.nexappoficial.sistema.bibliotecas.dto.InformacionAdicionalDto;
import com.nexappoficial.sistema.bibliotecas.dto.LibroDto;

import java.util.List;

public interface InformacionAdicionalService {

    List<InformacionAdicionalDto> obtenerInformacionAdicional();
    InformacionAdicionalDto obtenerInformacionAdicional(Long id);
    InformacionAdicionalDto guardarInformacionAdicional(InformacionAdicionalDto informacionAdicionalDto);
    void eliminarInformacionAdicional(Long id);

}