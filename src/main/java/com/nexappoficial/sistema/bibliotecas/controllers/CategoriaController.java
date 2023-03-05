package com.nexappoficial.sistema.bibliotecas.controllers;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;
import com.nexappoficial.sistema.bibliotecas.dto.CategoriaDto;
import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/obtenerCategorias")
    public ResponseEntity<RespuestaDto> obtenerCategorias() {
        List<CategoriaDto> categoriasDto =  categoriaService.obtenerCategorias();
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTROS_LISTADOS_CON_EXITO, HttpStatus.OK.value(), categoriasDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @GetMapping("/obtenerCategoria/{idCategoria}")
    public ResponseEntity<RespuestaDto> obtenerCategoria(@PathVariable Long idCategoria) {
        CategoriaDto categoriaDto = categoriaService.obtenerCategoria(idCategoria);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.OK.value(), categoriaDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @PostMapping("/guardarCategoria")
    public ResponseEntity<RespuestaDto> guardarCategoria(@RequestBody CategoriaDto categoriaDto) {
        CategoriaDto categoriaRespDto = categoriaService.guardarCategoria(categoriaDto);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_CREADO_CON_EXITO, HttpStatus.OK.value(), categoriaRespDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarCategoria/{idCategoria}")
    public ResponseEntity<RespuestaDto> eliminarCategoria(@PathVariable Long idCategoria) {
        categoriaService.eliminarCategoria(idCategoria);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ELIMINADO_CON_EXITO, HttpStatus.OK.value(), idCategoria);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }
}