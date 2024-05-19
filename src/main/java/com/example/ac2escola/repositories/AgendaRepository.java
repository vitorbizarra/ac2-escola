package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Agenda;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("SELECT a FROM Agenda a WHERE a.professor.id = ?1 AND (a.dataInicio BETWEEN ?2 AND ?3 OR a.dataFim BETWEEN ?2 AND ?3)")
    Optional<Agenda> findByProfessorAndDataInicioAndDataFim(Long professorId, LocalDate dataInicio, LocalDate dataFim);
}
