package com.example.ac2escola.services.curso;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.dto.curso.CursoDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.models.Agenda;
import com.example.ac2escola.models.Curso;
import com.example.ac2escola.models.Professor;
import com.example.ac2escola.repositories.CursoRepository;
import com.example.ac2escola.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    @Override
    public List<DadosCursoDTO> findAll() {
        return cursoRepository.findAll()
                .stream()
                .map((Curso curso) -> DadosCursoDTO.builder()
                        .id(curso.getId())
                        .descricao(curso.getDescricao())
                        .cargaHoraria(curso.getCargaHoraria())
                        .objetivos(curso.getObjetivos())
                        .ementa(curso.getEmenta())
                        .professores(curso.getProfessores()
                                .stream()
                                .map((Professor professor) -> DadosProfessorDTO.builder()
                                        .id(professor.getId())
                                        .nome(professor.getNome())
                                        .cpf(professor.getCpf())
                                        .rg(professor.getRg())
                                        .endereco(professor.getEndereco())
                                        .celular(professor.getCelular())
                                        .build())
                                .collect(Collectors.toList()))
                        .agendas(curso.getAgendas()
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
    public DadosCursoDTO create(CursoDTO data) {
        Curso curso = new Curso();

        curso.setDescricao(data.getDescricao());
        curso.setCargaHoraria(data.getCargaHoraria());
        curso.setObjetivos(data.getObjetivos());
        curso.setEmenta(data.getEmenta());

        curso = cursoRepository.save(curso);

        DadosCursoDTO dadosCursoDTO = DadosCursoDTO.builder()
                .id(curso.getId())
                .descricao(curso.getDescricao())
                .cargaHoraria(curso.getCargaHoraria())
                .objetivos(curso.getObjetivos())
                .ementa(curso.getEmenta())
                .build();

        return dadosCursoDTO;
    }

    @Override
    public DadosCursoDTO findById(Long id) {
        Curso curso = cursoRepository.findCursoFetchAgendasFetchProfessores(id);

        DadosCursoDTO dadosCursoDTO = DadosCursoDTO.builder()
                .id(curso.getId())
                .descricao(curso.getDescricao())
                .cargaHoraria(curso.getCargaHoraria())
                .objetivos(curso.getObjetivos())
                .ementa(curso.getEmenta())
                .professores(curso.getProfessores()
                        .stream()
                        .map((Professor professor) -> DadosProfessorDTO.builder()
                                .id(professor.getId())
                                .nome(professor.getNome())
                                .cpf(professor.getCpf())
                                .rg(professor.getRg())
                                .endereco(professor.getEndereco())
                                .celular(professor.getCelular())
                                .build())
                        .collect(Collectors.toList()))
                .agendas(curso.getAgendas()
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

        return dadosCursoDTO;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public DadosCursoDTO update(Long id, CursoDTO data) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setDescricao(data.getDescricao());
        curso.setCargaHoraria(data.getCargaHoraria());
        curso.setObjetivos(data.getObjetivos());
        curso.setEmenta(data.getEmenta());

        curso = cursoRepository.save(curso);

        DadosCursoDTO dadosCursoDTO = DadosCursoDTO.builder()
                .descricao(curso.getDescricao())
                .cargaHoraria(curso.getCargaHoraria())
                .objetivos(curso.getObjetivos())
                .ementa(curso.getEmenta())
                .build();

        return dadosCursoDTO;
    }

    @Override
    public void associateProfessor(Long id, Long idProfessor) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Professor professor = professorRepository.findProfessorFetchCursos(idProfessor);

        List<Curso> cursos = professor.getCursos();

        cursos.add(curso);

        professor.setCursos(cursos);

        professorRepository.save(professor);
    }
}
