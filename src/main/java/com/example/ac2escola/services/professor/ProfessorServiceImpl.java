package com.example.ac2escola.services.professor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.dto.professor.ProfessorDTO;
import com.example.ac2escola.models.Agenda;
import com.example.ac2escola.models.Curso;
import com.example.ac2escola.models.Professor;
import com.example.ac2escola.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public List<DadosProfessorDTO> findAll() {
        return professorRepository.findAll()
                .stream()
                .map((Professor professor) -> DadosProfessorDTO.builder()
                        .id(professor.getId())
                        .nome(professor.getNome())
                        .cpf(professor.getCpf())
                        .rg(professor.getRg())
                        .endereco(professor.getEndereco())
                        .celular(professor.getCelular())
                        .cursos(professor.getCursos()
                                .stream()
                                .map((Curso curso) -> DadosCursoDTO.builder()
                                        .id(curso.getId())
                                        .descricao(curso.getDescricao())
                                        .cargaHoraria(curso.getCargaHoraria())
                                        .objetivos(curso.getObjetivos())
                                        .ementa(curso.getEmenta())
                                        .build())
                                .collect(Collectors.toList()))
                        .agendas(professor.getAgendas()
                                .stream()
                                .map((Agenda agenda) -> DadosAgendaDTO.builder()
                                        .id(agenda.getId())
                                        .dataInicio(agenda.getDataInicio())
                                        .dataFim(agenda.getDataFim())
                                        .cidade(agenda.getCidade())
                                        .estado(agenda.getEstado())
                                        .cep(agenda.getCep())
                                        .resumo(agenda.getResumo())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public DadosProfessorDTO create(ProfessorDTO data) {
        Professor professor = new Professor();

        professor.setNome(data.getNome());
        professor.setCpf(data.getCpf());
        professor.setRg(data.getRg());
        professor.setEndereco(data.getEndereco());
        professor.setCelular(data.getCelular());

        professor = professorRepository.save(professor);

        DadosProfessorDTO dadosProfessorDTO = DadosProfessorDTO.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .cpf(professor.getCpf())
                .rg(professor.getRg())
                .endereco(professor.getEndereco())
                .celular(professor.getCelular())
                .build();

        return dadosProfessorDTO;
    }

    @Override
    public DadosProfessorDTO findById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        DadosProfessorDTO dadosProfessorDTO = DadosProfessorDTO.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .cpf(professor.getCpf())
                .rg(professor.getRg())
                .endereco(professor.getEndereco())
                .celular(professor.getCelular())
                .cursos(professor.getCursos()
                        .stream()
                        .map((Curso curso) -> DadosCursoDTO.builder()
                                .id(curso.getId())
                                .descricao(curso.getDescricao())
                                .cargaHoraria(curso.getCargaHoraria())
                                .objetivos(curso.getObjetivos())
                                .ementa(curso.getEmenta())
                                .build())
                        .collect(Collectors.toList()))
                .agendas(professor.getAgendas()
                        .stream()
                        .map((Agenda agenda) -> DadosAgendaDTO.builder()
                                .id(agenda.getId())
                                .dataInicio(agenda.getDataInicio())
                                .dataFim(agenda.getDataFim())
                                .cidade(agenda.getCidade())
                                .estado(agenda.getEstado())
                                .cep(agenda.getCep())
                                .resumo(agenda.getResumo())
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return dadosProfessorDTO;
    }

    @Override
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public DadosProfessorDTO update(Long id, ProfessorDTO data) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setNome(data.getNome());
        professor.setCpf(data.getCpf());
        professor.setRg(data.getRg());
        professor.setEndereco(data.getEndereco());
        professor.setCelular(data.getCelular());

        professor = professorRepository.save(professor);

        DadosProfessorDTO dadosProfessorDTO = DadosProfessorDTO.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .cpf(professor.getCpf())
                .rg(professor.getRg())
                .endereco(professor.getEndereco())
                .celular(professor.getCelular())
                .cursos(professor.getCursos()
                        .stream()
                        .map((Curso curso) -> DadosCursoDTO.builder()
                                .id(curso.getId())
                                .descricao(curso.getDescricao())
                                .cargaHoraria(curso.getCargaHoraria())
                                .objetivos(curso.getObjetivos())
                                .ementa(curso.getEmenta())
                                .build())
                        .collect(Collectors.toList()))
                .agendas(professor.getAgendas()
                        .stream()
                        .map((Agenda agenda) -> DadosAgendaDTO.builder()
                                .id(agenda.getId())
                                .dataInicio(agenda.getDataInicio())
                                .dataFim(agenda.getDataFim())
                                .cidade(agenda.getCidade())
                                .estado(agenda.getEstado())
                                .cep(agenda.getCep())
                                .resumo(agenda.getResumo())
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return dadosProfessorDTO;
    }
}
