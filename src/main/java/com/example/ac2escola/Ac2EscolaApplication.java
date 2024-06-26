package com.example.ac2escola;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2escola.controllers.AgendaController;
import com.example.ac2escola.controllers.CursoController;
import com.example.ac2escola.controllers.ProfessorController;
import com.example.ac2escola.dto.agenda.AgendaDTO;
import com.example.ac2escola.dto.curso.CursoDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.dto.professor.ProfessorDTO;

@SpringBootApplication
public class Ac2EscolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired AgendaController agendaController,
			@Autowired CursoController cursoController,
			@Autowired ProfessorController professorController) {
		return args -> {

			ProfessorDTO professorDTO = new ProfessorDTO(
					null,
					"Professor",
					"123.456.789-09",
					"99.999.999-99",
					"Rua 123, Sorocaba",
					"(99) 99999-9999");

			DadosProfessorDTO dadosProfessorDTO = professorController.create(professorDTO);

			CursoDTO cursoDTO = new CursoDTO(
					null,
					"ADS",
					120,
					"Analisar e desenvolver sistemas",
					"Analisar sistemas, desenvolver sistemas");

			DadosCursoDTO dadosCursoDTO = cursoController.create(cursoDTO);

			cursoController.associateProfessor(
					dadosCursoDTO.getId(),
					dadosProfessorDTO.getId());

			AgendaDTO agendaDTO = new AgendaDTO(
					null,
					dadosCursoDTO.getId(),
					dadosProfessorDTO.getId(),
					LocalDate.now(),
					LocalDate.now().plusMonths(1),
					"Sorocaba",
					"SP",
					"18000-000",
					"Resumo");

			agendaController.create(agendaDTO);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2EscolaApplication.class, args);
	}
}
