package com.example.ac2escola.services.professor;

import java.util.List;

import com.example.ac2escola.models.Professor;

public interface ProfessorService {
    List<Professor> findAll();

    Professor create(Professor professor);

    Professor findById(Long id);

    void delete(Long id);

    Professor update(Long id, Professor professor);
}
