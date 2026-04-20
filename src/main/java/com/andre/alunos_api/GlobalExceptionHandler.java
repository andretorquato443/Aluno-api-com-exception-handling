package com.andre.alunos_api;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.andre.alunos_api.Exception.ResourceNotFoundException;
import com.andre.alunos_api.Response.ApiError;

import jakarta.servlet.http.HttpServletRequest;


//Centraliza tratamento de excecoes para todos os controllers rest
@RestControllerAdvice
public class GlobalExceptionHandler {
    //intercepta excecao (metodo executado quando qualquer rnfe for lançada no programa)
    @ExceptionHandler(ResourceNotFoundException.class)
    //devolve mensagem http adequada a excecao
    @ResponseStatus(HttpStatus.NOT_FOUND)
    
    public ApiError handleNotFound(ResourceNotFoundException ex,HttpServletRequest request) {
    return new ApiError(
            404,
            "Not Found",
            ex.getMessage(),
            request.getRequestURI()
        );
    }
    
}
