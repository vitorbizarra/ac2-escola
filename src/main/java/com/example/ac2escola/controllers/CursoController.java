package com.example.ac2escola.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac2escola.dto.curso.CursoDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.services.curso.CursoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/curso")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @GetMapping
    public List<DadosCursoDTO> findAll() {
        return cursoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DadosCursoDTO create(@RequestBody CursoDTO curso) {
        return cursoService.create(curso);
    }

    @PutMapping("{id}")
    public void associateProfessor(@PathVariable Long id, @RequestBody Long idProfessor) {
        cursoService.associateProfessor(id, idProfessor);
    }
}
