package com.andre.alunos_api.Exception;

public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String mensagem) {
        super(mensagem);
        }
    
}
