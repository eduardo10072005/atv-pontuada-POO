package com.escola.academico.controller;

import com.escola.academico.model.Professor;
import com.escola.academico.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Professor> criar(@RequestBody Professor professor) {
        return ResponseEntity.status(201).body(service.criar(professor));
    }

    @GetMapping
    public List<Professor> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) { return service.buscar(id); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
