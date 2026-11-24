package com.escola.academico.controller;

import com.escola.academico.model.Disciplina;
import com.escola.academico.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping("/curso/{cursoId}")
    public ResponseEntity<Disciplina> criar(@PathVariable Long cursoId,
                                            @RequestBody Disciplina disciplina) {
        return ResponseEntity.status(201).body(service.criar(cursoId, disciplina));
    }

    @GetMapping
    public List<Disciplina> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Disciplina buscar(@PathVariable Long id) { return service.buscar(id); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
