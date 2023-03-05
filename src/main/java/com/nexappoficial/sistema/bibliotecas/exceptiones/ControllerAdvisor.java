package com.nexappoficial.sistema.bibliotecas.exceptiones;

import com.nexappoficial.sistema.bibliotecas.dto.RespuestaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<RespuestaDto> handleNoDataFoundException(NoDataFoundException exception, WebRequest webRequest) {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setMensaje(exception.getMessage());
        respuestaDto.setCodigo(HttpStatus.NOT_FOUND.value());
        respuestaDto.setData(null);
        return new ResponseEntity<>(respuestaDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataDigitalizedException.class)
    public ResponseEntity<RespuestaDto> handleNoDataDigitalizedException(NoDataDigitalizedException exception, WebRequest webRequest) {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setMensaje(exception.getMessage());
        respuestaDto.setCodigo(HttpStatus.NOT_IMPLEMENTED.value());
        respuestaDto.setData(null);
        return new ResponseEntity<>(respuestaDto, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(NoRecordsAvailable.class)
    public ResponseEntity<RespuestaDto> handleNoRecordsAvailable(NoRecordsAvailable exception, WebRequest webRequest) {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setMensaje(exception.getMessage());
        respuestaDto.setCodigo(HttpStatus.NOT_FOUND.value());
        respuestaDto.setData(null);
        return new ResponseEntity<>(respuestaDto, HttpStatus.NOT_FOUND);
    }
}
