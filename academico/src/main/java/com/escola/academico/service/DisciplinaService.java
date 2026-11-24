package com.escola.academico.service;

import com.escola.academico.model.Curso;
import com.escola.academico.model.Disciplina;
import com.escola.academico.repository.CursoRepository;
import com.escola.academico.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repo;
    private final CursoRepository cursoRepo;

    public DisciplinaService(DisciplinaRepository repo, CursoRepository cursoRepo) {
        this.repo = repo;
        this.cursoRepo = cursoRepo;
    }

    @Transactional
    public Disciplina criar(Long cursoId, Disciplina disciplina) {
        Curso curso = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        disciplina.setCurso(curso);
        return repo.save(disciplina);
    }

    public List<Disciplina> listar() { return repo.findAll(); }

    public Disciplina buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
