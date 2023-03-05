package com.nexappoficial.sistema.bibliotecas.controllers;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;
import com.nexappoficial.sistema.bibliotecas.dto.LibroDto;
import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.LibroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/obtenerLibros")
    public ResponseEntity<RespuestaDto> obtenerLibros() {
        List<LibroDto> librosDto = libroService.obtenerLibros();
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTROS_LISTADOS_CON_EXITO, HttpStatus.OK.value(), librosDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @GetMapping("/obtenerLibro/{idLibro}")
    public ResponseEntity<RespuestaDto> obtenerLibro(@PathVariable Long idLibro) {
        LibroDto libroDto = libroService.obtenerLibro(idLibro);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.OK.value(), libroDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @PostMapping("/guardarLibro")
    public ResponseEntity<RespuestaDto> guardarLibro(@RequestBody LibroDto libroDto) {
       LibroDto newLibroDto = libroService.guardarLibro(libroDto);
       RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_CREADO_CON_EXITO, HttpStatus.CREATED.value(), newLibroDto);
       return  new ResponseEntity<>(respuestaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarLibro/{idLibro}")
    public ResponseEntity<RespuestaDto> eliminarLibro(@PathVariable Long idLibro) {
        libroService.eliminarLibro(idLibro);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ELIMINADO_CON_EXITO, HttpStatus.OK.value(), idLibro);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

}
