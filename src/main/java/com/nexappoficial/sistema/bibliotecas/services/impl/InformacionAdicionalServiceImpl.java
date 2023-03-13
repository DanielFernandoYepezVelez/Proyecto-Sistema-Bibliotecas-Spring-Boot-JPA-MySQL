package com.nexappoficial.sistema.bibliotecas.services.impl;

import com.nexappoficial.sistema.bibliotecas.Utils.ErrorGenerico;
import com.nexappoficial.sistema.bibliotecas.dto.InformacionAdicionalDto;
import com.nexappoficial.sistema.bibliotecas.entities.InformacionAdicional;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataDigitalizedException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoDataFoundException;
import com.nexappoficial.sistema.bibliotecas.exceptiones.NoRecordsAvailable;
import com.nexappoficial.sistema.bibliotecas.repositories.InformacionAdicionalRepository;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.InformacionAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionAdicionalServiceImpl implements InformacionAdicionalService {

    @Autowired
    private InformacionAdicionalRepository informacionAdicionalRepository;

    @Override
    public List<InformacionAdicionalDto> obtenerInformacionAdicional() {
        List<InformacionAdicionalDto> informacionesDto;
        List<InformacionAdicional> informaciones = (List<InformacionAdicional>) informacionAdicionalRepository.findAll();

        if (!(ErrorGenerico.isNullOrEmpty(informaciones))) {
            informacionesDto = informaciones.stream().map(InformacionAdicionalDto::new).toList();
        } else {
            throw  new NoRecordsAvailable();
        }

        return informacionesDto;
    }

    @Override
    public InformacionAdicionalDto obtenerInformacionAdicional(Long id) {
        InformacionAdicionalDto informacionAdicionalDto;
        Optional<InformacionAdicional> informacionAdicional = informacionAdicionalRepository.findById(id);

        if (informacionAdicional.isPresent()) {
            informacionAdicionalDto = new InformacionAdicionalDto(informacionAdicional.get());
        } else {
            throw  new NoDataFoundException();
        }

        return informacionAdicionalDto;
    }

    @Override
    public InformacionAdicionalDto guardarInformacionAdicional(InformacionAdicionalDto informacionAdicionalDto) {
        InformacionAdicionalDto informacionAdicionalDto1;

        if (false) {
            throw  new NoDataDigitalizedException();
        } else {
            InformacionAdicional informacionAdicional = new InformacionAdicional();
            informacionAdicional.setIdioma(informacionAdicionalDto.getIdioma());
            informacionAdicional.setFechaPublicacion(informacionAdicionalDto.getFechaPublicacion());
            informacionAdicional.setLibro(informacionAdicionalDto.getLibro());

            InformacionAdicional informacionAdicionalResp1 = informacionAdicionalRepository.save(informacionAdicional);
            informacionAdicionalDto1 = new InformacionAdicionalDto(informacionAdicionalResp1);
        }

        return informacionAdicionalDto1;
    }

    @Override
    public void eliminarInformacionAdicional(Long id) {
        Optional<InformacionAdicional> informacionAdicional = informacionAdicionalRepository.findById(id);

        if (informacionAdicional.isPresent()) {
           informacionAdicionalRepository.deleteById(id);
        } else {
            throw new NoDataFoundException();
        }
    }
}
