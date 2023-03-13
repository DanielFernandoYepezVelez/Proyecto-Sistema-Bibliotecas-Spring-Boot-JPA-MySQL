package com.nexappoficial.sistema.bibliotecas.controllers;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;
import com.nexappoficial.sistema.bibliotecas.dto.InformacionAdicionalDto;
import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.InformacionAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/informacion")
public class InformacionAdicionalController {

    @Autowired
    private InformacionAdicionalService informacionAdicionalService;

    @GetMapping("/obtenerInformaciones")
    public  ResponseEntity<RespuestaDto> obtenerInformaciones() {
        List<InformacionAdicionalDto> informacionDto = informacionAdicionalService.obtenerInformacionAdicional();
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTROS_LISTADOS_CON_EXITO, HttpStatus.OK.value(), informacionDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @GetMapping("/obtenerInformacion/{id}")
    public ResponseEntity<RespuestaDto> obtenerInformacion(@PathVariable Long id) {
        InformacionAdicionalDto informacionDto = informacionAdicionalService.obtenerInformacionAdicional(id);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.OK.value(), informacionDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @PostMapping("/guardarInformacion")
    public ResponseEntity<RespuestaDto> guardarInformacion(@RequestBody InformacionAdicionalDto informacionAdicionalDto) {
        InformacionAdicionalDto newInformationAdicionalDto = informacionAdicionalService.guardarInformacionAdicional(informacionAdicionalDto);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.CREATED.value(), newInformationAdicionalDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarInformacion/{id}")
    public ResponseEntity<RespuestaDto> eliminarInformacion(@PathVariable Long id) {
        informacionAdicionalService.eliminarInformacionAdicional(id);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ELIMINADO_CON_EXITO, HttpStatus.OK.value(), id);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

}