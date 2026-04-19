package com.andre.alunos_api.Controller;
import com.andre.alunos_api.Models.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.andre.alunos_api.Service.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/alunos_api")
public class AlunoController {


    @Autowired
    private AlunoService service;

    //Criar
    @PostMapping
    public Aluno CriarAluno( @RequestBody Aluno aluno){
        return service.CriarAluno(aluno);
    }

    //Listar todos
    @GetMapping
    public List<Aluno> ListarAluno(){
        return service.ListarAluno();

    }

    //Encontra aluno por id
    @GetMapping("/{id}")
    public Aluno BuscarPorId(@PathVariable Long id){
        return service.BuscarPorId(id);
    }

    //Atualiza
    @PutMapping("/{id}")
    public Aluno Atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.Atualizar(id, aluno);
    }

    //Deleta 
    @DeleteMapping("/{id}")
    public void DeletaPorId(@PathVariable Long id ){
        service.DeletaPorId(id);
    }




    
}
