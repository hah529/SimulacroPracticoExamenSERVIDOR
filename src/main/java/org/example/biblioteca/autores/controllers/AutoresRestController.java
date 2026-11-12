package org.example.biblioteca.autores.controllers;

import org.example.biblioteca.autores.dto.AutorResponse;
import org.example.biblioteca.autores.services.AutoresService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** EJEMPLO RESUELTO: tu LibrosRestController sigue este patron. */
@RestController
@RequestMapping("${api.path}/${api.version}/autores")
public class AutoresRestController {

    private final AutoresService servicio;

    public AutoresRestController(AutoresService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<Page<AutorResponse>> findAll(
            @PageableDefault(size = 10, sort = "nombre") Pageable pageable) {
        return ResponseEntity.ok(servicio.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.findById(id));
    }
}
