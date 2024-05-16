package com.example.ac2escola.dto.curso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String descricao;
    private Integer cargaHoraria;
    private String objetivos;
    private String ementa;
}
