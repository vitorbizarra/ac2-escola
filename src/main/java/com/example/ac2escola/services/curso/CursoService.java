package com.example.ac2escola.services.curso;

import java.util.List;

import com.example.ac2escola.dto.curso.CursoDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;

public interface CursoService {
    List<DadosCursoDTO> findAll();

    DadosCursoDTO create(CursoDTO data);

    DadosCursoDTO findById(Long id);

    void delete(Long id);

    DadosCursoDTO update(Long id, CursoDTO data);

    void associateProfessor(Long id, Long idProfessor);
}
