package com.nexappoficial.sistema.bibliotecas.controllers;

import com.nexappoficial.sistema.bibliotecas.Utils.Constante;
import com.nexappoficial.sistema.bibliotecas.dto.EditorialDto;
import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import com.nexappoficial.sistema.bibliotecas.services.interfaces.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/obtenerEditoriales")
    public ResponseEntity<RespuestaDto> obtenerEditoriales() {
        List<EditorialDto> editorialesDto = editorialService.obtenerEditoriales();
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTROS_LISTADOS_CON_EXITO, HttpStatus.OK.value(), editorialesDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @GetMapping("/obtenerEditorial/{idEditorial}")
    public ResponseEntity<RespuestaDto> obtenerEditorial(@PathVariable Long idEditorial) {
        EditorialDto editorialDto = editorialService.obtenerEditorial(idEditorial);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ENCONTRADO_CORRECTAMENTE, HttpStatus.OK.value(), editorialDto);
        return  new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @PostMapping("/guardarEditorial")
    public ResponseEntity<RespuestaDto> guardarEditorial(@RequestBody EditorialDto editorialDto) {
        EditorialDto editorialRespDto = editorialService.guardarEditorial(editorialDto);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_CREADO_CON_EXITO, HttpStatus.OK.value(), editorialRespDto);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarEditorial/{idEditorial}")
    public ResponseEntity<RespuestaDto> eliminarEditorial(@PathVariable Long idEditorial) {
        editorialService.eliminarEditorial(idEditorial);
        RespuestaDto respuestaDto = new RespuestaDto(Constante.MSG_REGISTRO_ELIMINADO_CON_EXITO, HttpStatus.OK.value(), idEditorial);
        return new ResponseEntity<>(respuestaDto, HttpStatus.OK);
    }

}
