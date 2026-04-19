package com.andre.alunos_api.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.andre.alunos_api.Models.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
