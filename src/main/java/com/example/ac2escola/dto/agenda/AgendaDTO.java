package com.example.ac2escola.dto.agenda;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDTO {
    private Long id;
    private Long curso;
    private Long professor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String cidade;
    private String estado;
    private String cep;
    private String resumo;
}
