package com.nexappoficial.sistema.bibliotecas.controllers;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;
import com.nexappoficial.sistema.bibliotecas.dto.AutorDto;
import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/obtenerAutores")
    public ResponseEntity<RespuestaDto> obtenerAutores() {
        List<AutorDto> autoresDto = autorService.obtenerAutores();
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTROS_LISTADOS_CON_EXITO, HttpStatus.OK.value(), autoresDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @GetMapping("/obtenerAutor/{idAutor}")
    public ResponseEntity<RespuestaDto> obtenerAutor(@PathVariable Long idAutor) {
        AutorDto autorDto = autorService.obtenerAutor(idAutor);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.OK.value(), autorDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @PostMapping("/guardarAutor")
    public ResponseEntity<RespuestaDto> guardarAutor(@RequestBody AutorDto autorDto) {
        AutorDto autorDtoResp = autorService.guardarAutor(autorDto);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_CREADO_CON_EXITO, HttpStatus.OK.value(), autorDtoResp);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarAutor/{idActor}")
    public ResponseEntity<RespuestaDto> eliminarAutor(@PathVariable Long idActor) {
        autorService.eliminarAutor(idActor);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ELIMINADO_CON_EXITO, HttpStatus.OK.value(), idActor);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

}