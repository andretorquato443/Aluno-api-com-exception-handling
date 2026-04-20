package com.andre.alunos_api.Controller;
import com.andre.alunos_api.DTO.AlunoRequestDTO;
import com.andre.alunos_api.DTO.AlunoResponseDTO;
import com.andre.alunos_api.Models.Aluno;
import com.andre.alunos_api.Response.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<AlunoResponseDTO>> CriarAluno(@RequestBody AlunoRequestDTO dto){

        //objeto tipo Aluno é delegado as outras camadas:
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setFaltas(dto.getFaltas());

        Aluno salvo = service.CriarAluno(aluno);

        AlunoResponseDTO responseDTO=new AlunoResponseDTO(
                salvo.getId(),
                salvo.getMatricula(),
                salvo.getNome(),
                salvo.getFaltas()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse<>(201, "Aluno criado com sucesso", responseDTO));
    }
    

    //listar usando dto
    @GetMapping
    public ResponseEntity<ApiResponse<List<AlunoResponseDTO>>>  ListarAluno(){
         List<AlunoResponseDTO> lista= service.ListarAluno()
        .stream()
            .map(a -> new AlunoResponseDTO(
                    a.getId(),
                    a.getMatricula(),
                    a.getNome(),
                    a.getFaltas()
            ))
            .toList();

        return ResponseEntity.ok(new ApiResponse<>(200, "Lista de alunos", lista));

    }

    //Encontra aluno por id usando dto
    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<AlunoResponseDTO>> BuscarPorId(@PathVariable Long id){
        Aluno aluno= service.BuscarPorId(id);
        AlunoResponseDTO dto= new AlunoResponseDTO(
                aluno.getId(),
                aluno.getMatricula(),
                aluno.getNome(),
                aluno.getFaltas()
            );

        return ResponseEntity.ok(new ApiResponse<>(200, "Aluno encontrado", dto));
    }

    //Atualiza usando dto 
    @PutMapping("/{id}")
    public  ResponseEntity<ApiResponse<AlunoResponseDTO>> Atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setFaltas(dto.getFaltas());

        Aluno atualizado = service.Atualizar(id, aluno);
        
        AlunoResponseDTO responseDTO= new AlunoResponseDTO(
            atualizado.getId(),
            atualizado.getMatricula(),
            atualizado.getNome(),
            atualizado.getFaltas()
        );

        return ResponseEntity.ok(new ApiResponse<>(200, "Aluno atualizado", responseDTO));

    }

    //Deleta 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletaPorId(@PathVariable Long id ){
        service.DeletaPorId(id);
        return ResponseEntity.noContent().build();
    }




    
}
