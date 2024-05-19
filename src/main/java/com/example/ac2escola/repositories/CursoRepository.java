package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.professores p WHERE c.id = :id")
    Curso findCursoFetchProfessores(@Param("id") Long id);

    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.agendas a WHERE c.id = :id")
    Curso findCursoFetchAgendas(@Param("id") Long id);

    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.agendas a LEFT JOIN FETCH c.professores p WHERE c.id = :id")
    Curso findCursoFetchAgendasFetchProfessores(@Param("id") Long id);
}
