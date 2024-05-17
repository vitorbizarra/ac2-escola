package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Agenda;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("select a from Agenda a WHERE a.professor = :professor AND data_inicio = :data_inicio AND data_fim = :data_fim")
    Agenda findByProfessorAndDataInicioAndDataFim(
            @Param("professor") Long professor,
            @Param("data_inicio") LocalDate dataInicio,
            @Param("data_fim") LocalDate dataFim);
}
