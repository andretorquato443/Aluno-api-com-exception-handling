package com.andre.alunos_api.Models;




import jakarta.persistence.*;

//SpringBoot vê como tabela no banco de dados a classe Aluno
@Entity

public class Aluno {
    //aqui estao os atributos do objeto 'aluno'

    //id é a primary key,gerada automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //define que o atributo 'matricula' deve ser unico no banco de dados 
    @Column (unique=true)
    private Integer matricula;

    private String nome;

    private Integer faltas;

    //metodos construtores:
    public Aluno(){}

    //setters:
    public void setMatricula(int matricula){
        this.matricula=matricula;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setFaltas(int faltas){
        this.faltas=faltas;
    }

    //getters:
    public Long getId() {
        return id;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){ 
        return nome;
    }
    
    public int getFaltas(){
        return faltas;
    }



    //

}
