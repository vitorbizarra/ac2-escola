package com.example.ac2escola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    @NonNull
    private String nome;

    @Column(length = 20, nullable = false)
    @NonNull
    private String cpf;

    @Column(length = 20, nullable = false)
    @NonNull
    private String rg;

    @Column(length = 255, nullable = false)
    @NonNull
    private String endereco;

    @Column(length = 20, nullable = false)
    @NonNull
    private String celular;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "curso_professor", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

    @OneToMany(mappedBy = "professor")
    private List<Agenda> agendas;
}
