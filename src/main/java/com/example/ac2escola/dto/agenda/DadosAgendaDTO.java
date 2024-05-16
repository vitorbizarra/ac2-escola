package com.example.ac2escola.dto.agenda;

import java.time.LocalDate;

import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosAgendaDTO {
    private Long id;
    private DadosCursoDTO curso;
    private DadosProfessorDTO professor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String cidade;
    private String estado;
    private String cep;
    private String resumo;
}
