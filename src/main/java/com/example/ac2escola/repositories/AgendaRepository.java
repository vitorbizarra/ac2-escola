package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Agenda;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("select a from Agenda a where a.professor_id = ?1 and data_inicio = ?2 and data_fim = ?3 LIMIT 1")
    Agenda findByProfessorAndDataInicioAndDataFim(Long professor, LocalDate dataInicio, LocalDate dataFim);
}
