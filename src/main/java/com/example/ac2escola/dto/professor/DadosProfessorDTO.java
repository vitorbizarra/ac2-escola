package com.example.ac2escola.dto.professor;

import java.util.List;

import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosProfessorDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private List<DadosCursoDTO> cursos;
    private List<DadosAgendaDTO> agendas;
}
