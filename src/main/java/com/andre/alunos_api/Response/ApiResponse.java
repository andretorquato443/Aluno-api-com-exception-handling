package com.andre.alunos_api.Response;

import java.time.LocalDateTime;

//classe usa tipo generico , responsavel pelas mensagens de sucesso das operacoes do programa
public class ApiResponse<T> {

    //atributos da classe ,informam tempo , status e mensagem padronizada da operacao bem sucedida
    private LocalDateTime timestamp;

    private int status;

    private String message;

    private T data;
    //metodo construtor 
    public ApiResponse(int status, String message, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //getters
    public LocalDateTime getTimestamp() {
        return timestamp; 
    }

    public int getStatus() {
        return status; 
    }

    public String getMessage() {
        return message; 
    }
        
    public T getData() {
        return data; 
    }
    
}
