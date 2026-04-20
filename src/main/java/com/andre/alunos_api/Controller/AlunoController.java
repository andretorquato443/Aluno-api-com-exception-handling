package com.andre.alunos_api.Controller;
import com.andre.alunos_api.DTO.AlunoRequestDTO;
import com.andre.alunos_api.DTO.AlunoResponseDTO;
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

    //Criar usando dto na saida e entrada do metodo :desacopla entidade
    @PostMapping
    public AlunoResponseDTO CriarAluno(@RequestBody AlunoRequestDTO dto){

        //objeto tipo Aluno é delegado as outras camadas:
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setFaltas(dto.getFaltas());

        Aluno salvo = service.CriarAluno(aluno);

        return new AlunoResponseDTO(
                salvo.getId(),
                salvo.getMatricula(),
                salvo.getNome(),
                salvo.getFaltas()
        );
    }

    //listar usando dto
    @GetMapping
    public List<AlunoResponseDTO> ListarAluno(){
        return service.ListarAluno()
        .stream()
            .map(a -> new AlunoResponseDTO(
                    a.getId(),
                    a.getMatricula(),
                    a.getNome(),
                    a.getFaltas()
            ))
            .toList();

    }

    //Encontra aluno por id usando dto
    @GetMapping("/{id}")
    public  AlunoResponseDTO BuscarPorId(@PathVariable Long id){
        Aluno aluno= service.BuscarPorId(id);
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getMatricula(),
                aluno.getNome(),
                aluno.getFaltas()
            );
    }

    //Atualiza
    @PutMapping("/{id}")
    public AlunoResponseDTO Atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setFaltas(dto.getFaltas());

        Aluno atualizado = service.Atualizar(id, aluno);
        
        return new AlunoResponseDTO(
            atualizado.getId(),
            atualizado.getMatricula(),
            atualizado.getNome(),
            atualizado.getFaltas()
        );
    }

    //Deleta 
    @DeleteMapping("/{id}")
    public void DeletaPorId(@PathVariable Long id ){
        service.DeletaPorId(id);
    }




    
}
