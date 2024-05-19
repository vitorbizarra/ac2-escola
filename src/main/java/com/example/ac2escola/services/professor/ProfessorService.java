package com.example.ac2escola.services.professor;

import java.util.List;

import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.dto.professor.ProfessorDTO;

public interface ProfessorService {
    List<DadosProfessorDTO> findAll();

    DadosProfessorDTO create(ProfessorDTO data);

    DadosProfessorDTO findById(Long id);

    void delete(Long id);

    DadosProfessorDTO update(Long id, ProfessorDTO data);
}
