package com.andre.alunos_api.DTO;
//response dto controla o que o cliente pode ver
public class AlunoResponseDTO {
    //atributos
    private Long id;

    private Integer matricula;

    private String nome;

    private Integer faltas;

    //metodo contrutor 
    public AlunoResponseDTO(Long id, Integer matricula, String nome, Integer faltas) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.faltas = faltas;
    }

    //getters
    public Long getId(){
        return id;
    }

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
