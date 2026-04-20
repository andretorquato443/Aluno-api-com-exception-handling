package com.andre.alunos_api.Response;

import java.time.LocalDateTime;

//classe responsavel pelas mensagens de erro ao tentar realizar operacoes do programa
public class ApiError {
    //atributos da classe ,informam tempo , status ,mensagem e caminho de forma padronizada da operacao bem sucedida
    private LocalDateTime timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

    //metodo construtor
    public ApiError(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    
    //getters
    public LocalDateTime getTimestamp() {
        return timestamp; 
    }

    public int getStatus() {
        return status; 
    }

    public String getError() {
        return error; 
    }

    public String getMessage() {
        return message; 
    }

    public String getPath() { 
        return path; 
    }
    
}
