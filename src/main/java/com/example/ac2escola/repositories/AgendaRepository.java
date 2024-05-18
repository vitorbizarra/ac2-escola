package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Agenda;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("select a from Agenda a where a.professor.id = ?1 and a.dataInicio = ?2 and a.dataFim = ?3")
    Optional<Agenda> findByProfessorAndDataInicioAndDataFim(Long professorId, LocalDate dataInicio, LocalDate dataFim);
}
