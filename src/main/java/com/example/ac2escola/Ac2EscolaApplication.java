package com.example.ac2escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2escola.models.Curso;
import com.example.ac2escola.models.Professor;
import com.example.ac2escola.repositories.CursoRepository;
import com.example.ac2escola.repositories.ProfessorRepository;

@SpringBootApplication
public class Ac2EscolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired ProfessorRepository professorRepository) {
		return args -> {
			Professor professor = professorRepository.save(new Professor(
					null,
					"Professor",
					"123.456.789-09",
					"99.999.999-99",
					"Rua 123, Sorocaba",
					"(99) 99999-9999",
					null,
					null));

			Curso curso = cursoRepository.save(new Curso(
					null,
					"ADS",
					120,
					"Analisar e desenvolver sistemas",
					"Analisar sistemas, desenvolver sistemas",
					null,
					null));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2EscolaApplication.class, args);
	}

}
