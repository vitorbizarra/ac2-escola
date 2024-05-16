package com.example.ac2escola.services.curso;

import java.util.List;

import com.example.ac2escola.models.Curso;

public interface CursoService {
    List<Curso> findAll();

    Curso create(Curso curso);

    Curso findById(Long id);

    void delete(Long id);

    Curso update(Long id, Curso curso);
}
