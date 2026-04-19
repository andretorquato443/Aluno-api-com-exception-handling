package com.andre.alunos_api.Service;
import com.andre.alunos_api.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.alunos_api.Exception.ResourceNotFoundException;
import com.andre.alunos_api.Models.Aluno;
import java.util.List;


@Service
public class AlunoService {
    

    //objeto da interface é instanciada dinamicamente, de forma abstrata
    @Autowired
    private AlunoRepository repository;


    //Criar
    public Aluno CriarAluno(Aluno aluno){
        return repository.save(aluno);
    }

    //Listar todos
    public List<Aluno> ListarAluno(){ 
        return repository.findAll();
    }

    //Encontrar aluno por Id.Se nao achar, lança mensagem de erro
    public Aluno BuscarPorId(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }

    //Atualiza
    public Aluno Atualizar(Long id,Aluno novoAluno ){
        Aluno aluno = BuscarPorId(id);
        aluno.setNome(novoAluno.getNome());
        aluno.setMatricula(novoAluno.getMatricula());
        aluno.setFaltas(novoAluno.getFaltas());
        return repository.save(aluno);
    }

    //Deleta
    public void DeletaPorId(Long id){
        repository.deleteById(id);
    }


}
