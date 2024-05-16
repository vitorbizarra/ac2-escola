package com.example.ac2escola.dto.curso;

import java.util.List;

import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosCursoDTO {
    private Long id;
    private String descricao;
    private Integer cargaHoraria;
    private String objetivos;
    private String ementa;
    private List<DadosProfessorDTO> professores;
    private List<DadosAgendaDTO> agendas;
}
