package com.example.ac2escola.models;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @NonNull
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @NonNull
    private Professor professor;

    @Column(name = "data_inicio", nullable = false)
    @NonNull
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    @NonNull
    private LocalDate dataFim;

    @Column(nullable = false)
    @NonNull
    private String cidade;

    @Column(nullable = false)
    @NonNull
    private String estado;

    @Column(nullable = false)
    @NonNull
    private String cep;

    @Column
    @NonNull
    private String resumo;
}
