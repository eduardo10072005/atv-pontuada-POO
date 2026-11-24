package com.escola.academico.service;

import com.escola.academico.model.Curso;
import com.escola.academico.model.Disciplina;
import com.escola.academico.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Curso criar(Curso curso) {
        if (curso.getDisciplinas() != null) {
            for (Disciplina d : curso.getDisciplinas()) {
                d.setCurso(curso);
            }
        }
        return repo.save(curso);
    }

    public List<Curso> listar() { return repo.findAll(); }

    public Curso buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
