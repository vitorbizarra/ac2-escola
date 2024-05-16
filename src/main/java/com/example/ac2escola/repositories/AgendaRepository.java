package com.example.ac2escola.repositories;

import com.example.ac2escola.models.Agenda;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Agenda findByProfessorAndDataInicioAndDataFim(Long professor, LocalDate dataInicio, LocalDate dataFim);
}
