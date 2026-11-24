package com.escola.academico.service;

import com.escola.academico.model.PerfilProfessor;
import com.escola.academico.model.Professor;
import com.escola.academico.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Professor criar(Professor professor) {
        PerfilProfessor perfil = professor.getPerfil();
        if (perfil != null) {
            perfil.setProfessor(professor);
        }
        return repo.save(professor);
    }

    public List<Professor> listar() { return repo.findAll(); }

    public Professor buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
