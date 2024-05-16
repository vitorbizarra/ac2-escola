package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("select p from Professor p left join fetch p.cursos c WHERE p.id = :id")
    Professor findProfessorFetchCursos(@Param("id") Long id);

    @Query("select p from Professor p left join fetch p.agendas a WHERE p.id = :id")
    Professor findProfessorFetchAgendas(@Param("id") Long id);
}
