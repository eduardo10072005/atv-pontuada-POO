package com.escola.academico.controller;

import com.escola.academico.model.Curso;
import com.escola.academico.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        return ResponseEntity.status(201).body(service.criar(curso));
    }

    @GetMapping
    public List<Curso> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) { return service.buscar(id); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
