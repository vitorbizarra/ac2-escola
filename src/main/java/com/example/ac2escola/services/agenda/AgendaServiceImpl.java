package com.example.ac2escola.services.agenda;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2escola.dto.agenda.AgendaDTO;
import com.example.ac2escola.dto.agenda.DadosAgendaDTO;
import com.example.ac2escola.dto.curso.DadosCursoDTO;
import com.example.ac2escola.dto.professor.DadosProfessorDTO;
import com.example.ac2escola.models.Agenda;
import com.example.ac2escola.models.Curso;
import com.example.ac2escola.models.Professor;
import com.example.ac2escola.repositories.AgendaRepository;
import com.example.ac2escola.repositories.CursoRepository;
import com.example.ac2escola.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository agendaRepository;
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    @Override
    public List<DadosAgendaDTO> findAll() {
        return agendaRepository.findAll()
                .stream()
                .map((Agenda agenda) -> DadosAgendaDTO.builder()
                        .id(agenda.getId())
                        .curso(DadosCursoDTO.builder()
                                .id(agenda.getCurso().getId())
                                .descricao(agenda.getCurso().getDescricao())
                                .cargaHoraria(agenda.getCurso().getCargaHoraria())
                                .objetivos(agenda.getCurso().getObjetivos())
                                .ementa(agenda.getCurso().getEmenta())
                                .build())
                        .professor(DadosProfessorDTO.builder()
                                .id(agenda.getProfessor().getId())
                                .nome(agenda.getProfessor().getNome())
                                .cpf(agenda.getProfessor().getCpf())
                                .rg(agenda.getProfessor().getRg())
                                .endereco(agenda.getProfessor().getEndereco())
                                .celular(agenda.getProfessor().getCelular())
                                .build())
                        .dataInicio(agenda.getDataInicio())
                        .dataFim(agenda.getDataFim())
                        .cidade(agenda.getCidade())
                        .estado(agenda.getEstado())
                        .cep(agenda.getCep())
                        .resumo(agenda.getResumo())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public DadosAgendaDTO create(AgendaDTO data) {
        Curso curso = cursoRepository.findById(data.getCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Optional<Agenda> agendaProfessorInformado = agendaRepository
                .findByProfessorAndDataInicioAndDataFim(data.getProfessor(), data.getDataInicio(),
                        data.getDataFim());

        if (agendaProfessorInformado == null) {
            new RuntimeException("Professor não disponível no período informado");
        }

        Professor professor = professorRepository.findById(data.getProfessor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Agenda agenda = new Agenda();
        agenda.setCurso(curso);
        agenda.setProfessor(professor);
        agenda.setDataInicio(data.getDataInicio());
        agenda.setDataFim(data.getDataFim());
        agenda.setCidade(data.getCidade());
        agenda.setEstado(data.getEstado());
        agenda.setCep(data.getCep());
        agenda.setResumo(data.getResumo());

        agenda = agendaRepository.save(agenda);

        DadosAgendaDTO dadosAgendaDTO = DadosAgendaDTO.builder()
                .id(agenda.getId())
                .curso(DadosCursoDTO.builder()
                        .id(agenda.getCurso().getId())
                        .descricao(agenda.getCurso().getDescricao())
                        .cargaHoraria(agenda.getCurso().getCargaHoraria())
                        .objetivos(agenda.getCurso().getObjetivos())
                        .ementa(agenda.getCurso().getEmenta())
                        .build())
                .professor(DadosProfessorDTO.builder()
                        .id(agenda.getProfessor().getId())
                        .nome(agenda.getProfessor().getNome())
                        .cpf(agenda.getProfessor().getCpf())
                        .rg(agenda.getProfessor().getRg())
                        .endereco(agenda.getProfessor().getEndereco())
                        .celular(agenda.getProfessor().getCelular())
                        .build())
                .dataInicio(agenda.getDataInicio())
                .dataFim(agenda.getDataFim())
                .cidade(agenda.getCidade())
                .estado(agenda.getEstado())
                .cep(agenda.getCep())
                .resumo(agenda.getResumo())
                .build();

        return dadosAgendaDTO;
    }

    @Override
    public DadosAgendaDTO findById(Long id) {
        Agenda agenda = agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        DadosAgendaDTO dadosAgendaDTO = DadosAgendaDTO.builder()
                .id(agenda.getId())
                .curso(DadosCursoDTO.builder()
                        .id(agenda.getCurso().getId())
                        .descricao(agenda.getCurso().getDescricao())
                        .cargaHoraria(agenda.getCurso().getCargaHoraria())
                        .objetivos(agenda.getCurso().getObjetivos())
                        .ementa(agenda.getCurso().getEmenta())
                        .build())
                .professor(DadosProfessorDTO.builder()
                        .id(agenda.getProfessor().getId())
                        .nome(agenda.getProfessor().getNome())
                        .cpf(agenda.getProfessor().getCpf())
                        .rg(agenda.getProfessor().getRg())
                        .endereco(agenda.getProfessor().getEndereco())
                        .celular(agenda.getProfessor().getCelular())
                        .build())
                .dataInicio(agenda.getDataInicio())
                .dataFim(agenda.getDataFim())
                .cidade(agenda.getCidade())
                .estado(agenda.getEstado())
                .cep(agenda.getCep())
                .resumo(agenda.getResumo())
                .build();

        return dadosAgendaDTO;
    }

    @Override
    public void delete(Long id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public DadosAgendaDTO update(Long id, AgendaDTO data) {
        Curso curso = cursoRepository.findById(data.getCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Optional<Agenda> agendaProfessorInformado = agendaRepository
                .findByProfessorAndDataInicioAndDataFim(data.getProfessor(), data.getDataInicio(),
                        data.getDataFim());

        if (agendaProfessorInformado == null) {
            new RuntimeException("Professor não disponível no período informado");
        }

        Professor professor = professorRepository.findById(data.getProfessor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Agenda agenda = agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));
        agenda.setCurso(curso);
        agenda.setProfessor(professor);
        agenda.setDataInicio(data.getDataInicio());
        agenda.setDataFim(data.getDataFim());
        agenda.setCidade(data.getCidade());
        agenda.setEstado(data.getEstado());
        agenda.setCep(data.getCep());
        agenda.setResumo(data.getResumo());

        agenda = agendaRepository.save(agenda);

        DadosAgendaDTO dadosAgendaDTO = DadosAgendaDTO.builder()
                .id(agenda.getId())
                .curso(DadosCursoDTO.builder()
                        .id(agenda.getCurso().getId())
                        .descricao(agenda.getCurso().getDescricao())
                        .cargaHoraria(agenda.getCurso().getCargaHoraria())
                        .objetivos(agenda.getCurso().getObjetivos())
                        .ementa(agenda.getCurso().getEmenta())
                        .build())
                .professor(DadosProfessorDTO.builder()
                        .id(agenda.getProfessor().getId())
                        .nome(agenda.getProfessor().getNome())
                        .cpf(agenda.getProfessor().getCpf())
                        .rg(agenda.getProfessor().getRg())
                        .endereco(agenda.getProfessor().getEndereco())
                        .celular(agenda.getProfessor().getCelular())
                        .build())
                .dataInicio(agenda.getDataInicio())
                .dataFim(agenda.getDataFim())
                .cidade(agenda.getCidade())
                .estado(agenda.getEstado())
                .cep(agenda.getCep())
                .resumo(agenda.getResumo())
                .build();

        return dadosAgendaDTO;
    }
}
