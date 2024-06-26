package com.example.ac2escola.models;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    @NonNull
    private String descricao;

    @Column
    @NonNull
    private Integer cargaHoraria;

    @Column(length = 255, nullable = false)
    @NonNull
    private String objetivos;

    @Column(length = 255, nullable = false)
    @NonNull
    private String ementa;

    @ManyToMany(mappedBy = "cursos")
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<Agenda> agendas = new ArrayList<>();
}
