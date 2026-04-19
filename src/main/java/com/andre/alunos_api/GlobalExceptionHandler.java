package com.andre.alunos_api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.andre.alunos_api.Exception.ResourceNotFoundException;


//Centraliza tratamento de excecoes para todos os controllers rest
@RestControllerAdvice
public class GlobalExceptionHandler {
    //intercepta excecao (metodo executado quando qualquer rnfe for lançada no programa)
    @ExceptionHandler(ResourceNotFoundException.class)
    //devolve mensagem http adequada a excecao
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> HandleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> erro = new HashMap<>();

        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 404);
        erro.put("error", "Not Found");
        erro.put("message", ex.getMessage());

        return erro;
    }
    
}
