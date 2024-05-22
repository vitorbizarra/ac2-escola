package com.example.ac2escola.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac2escola.dto.agenda.AgendaDTO;
import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.services.agenda.AgendaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/agenda")
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaService agendaService;

    @GetMapping
    public List<DadosAgendaDTO> findAll() {
        return agendaService.findAll();
    }

    @GetMapping("{id}")
    public List<DadosAgendaDTO> findAll(@PathVariable Long id) {
        return agendaService.findProfessorAgenda(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DadosAgendaDTO create(@RequestBody AgendaDTO agenda) {
        return agendaService.create(agenda);
    }
}
