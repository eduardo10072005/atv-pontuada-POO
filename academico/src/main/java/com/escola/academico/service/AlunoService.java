package com.escola.academico.service;

import com.escola.academico.model.Aluno;
import com.escola.academico.model.Disciplina;
import com.escola.academico.repository.AlunoRepository;
import com.escola.academico.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repo;
    private final DisciplinaRepository disciplinaRepo;

    public AlunoService(AlunoRepository repo, DisciplinaRepository disciplinaRepo) {
        this.repo = repo;
        this.disciplinaRepo = disciplinaRepo;
    }

    @Transactional
    public Aluno criar(Aluno aluno) { return repo.save(aluno); }

    public List<Aluno> listar() { return repo.findAll(); }

    public Aluno buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @Transactional
    public Aluno matricular(Long alunoId, Long disciplinaId) {
        Aluno aluno = buscar(alunoId);
        Disciplina d = disciplinaRepo.findById(disciplinaId)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        aluno.getDisciplinas().add(d);
        return repo.save(aluno);
    }

    @Transactional
    public Aluno desmatricular(Long alunoId, Long disciplinaId) {
        Aluno aluno = buscar(alunoId);
        aluno.getDisciplinas().removeIf(d -> d.getId().equals(disciplinaId));
        return repo.save(aluno);
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
