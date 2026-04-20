package com.andre.alunos_api.DTO;




//request dto controla o que o cliente pode enviar 
public class AlunoRequestDTO {
    //atributos
    private Integer matricula;

    private String nome;

    private Integer faltas;


    //criacao do objeto é automatico ,construtor sem parametros

    //getters
    public Integer getMatricula() {
        return matricula; 
    }

    public String getNome() {
        return nome;
    }

    public Integer getFaltas() {
        return faltas; 
    }

}
