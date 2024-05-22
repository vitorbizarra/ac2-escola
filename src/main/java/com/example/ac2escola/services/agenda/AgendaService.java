package com.example.ac2escola.services.agenda;

import java.util.List;

import com.example.ac2escola.dto.agenda.AgendaDTO;
import com.example.ac2escola.dto.agenda.DadosAgendaDTO;

public interface AgendaService {
    List<DadosAgendaDTO> findAll();

    List<DadosAgendaDTO> findProfessorAgenda(Long id);

    DadosAgendaDTO create(AgendaDTO data);

    DadosAgendaDTO findById(Long id);

    void delete(Long id);

    DadosAgendaDTO update(Long id, AgendaDTO data);
}
