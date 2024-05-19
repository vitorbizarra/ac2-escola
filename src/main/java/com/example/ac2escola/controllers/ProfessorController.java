package com.example.ac2escola.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.dto.professor.ProfessorDTO;
import com.example.ac2escola.services.professor.ProfessorService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping
    public List<DadosProfessorDTO> findAll() {
        return professorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DadosProfessorDTO create(@RequestBody ProfessorDTO professor) {
        return professorService.create(professor);
    }
}
