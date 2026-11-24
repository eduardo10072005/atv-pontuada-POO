package com.escola.academico.controller;

import com.escola.academico.model.Aluno;
import com.escola.academico.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        return ResponseEntity.status(201).body(service.criar(aluno));
    }

    @GetMapping
    public List<Aluno> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping("/{alunoId}/disciplinas/{disciplinaId}")
    public Aluno matricular(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return service.matricular(alunoId, disciplinaId);
    }

    @DeleteMapping("/{alunoId}/disciplinas/{disciplinaId}")
    public Aluno desmatricular(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return service.desmatricular(alunoId, disciplinaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
