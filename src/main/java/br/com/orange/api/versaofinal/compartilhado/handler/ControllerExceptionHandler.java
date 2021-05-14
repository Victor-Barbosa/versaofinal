package br.com.orange.api.versaofinal.compartilhado.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> valida(MethodArgumentNotValidException ex) {


        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String titulo = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String detalhe = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ExceptionResponse er = new ExceptionResponse(titulo, detalhe,String.valueOf(HttpStatus.BAD_REQUEST) );

        return ResponseEntity.status(400).body(er);



    }
}
