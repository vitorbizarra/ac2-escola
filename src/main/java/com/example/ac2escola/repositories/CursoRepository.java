package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("select c from Curso c left join fetch c.professores p WHERE c.id = :id")
    Curso findCursoFetchProfessores(@Param("id") Long id);

    @Query("select c from Curso c left join fetch c.agendas a WHERE c.id = :id")
    Curso findCursoFetchAgendas(@Param("id") Long id);
}
