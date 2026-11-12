package org.example.biblioteca.libros.controllers;

import org.example.biblioteca.libros.services.LibrosService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * TAREA 6 · Los seis endpoints de la tabla del enunciado.
 * Fijate en AutoresRestController: es el mismo patron.
 */
@RestController
@RequestMapping("${api.path}/${api.version}/libros")
public class LibrosRestController {

    private final LibrosService servicio;

    public LibrosRestController(LibrosService servicio) {
        this.servicio = servicio;
    }

    // TODO 6 · los seis endpoints de la tabla de la TAREA 6 del enunciado

    /** YA ESTA HECHO. Para comprobar que todo arranca: GET /api/v1/libros/ping */
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("La API de libros responde");
    }

    /**
     * YA ESTA HECHO. Llamalo en el GET del listado: solo deja ordenar por
     * id, titulo, precio, stock y anioPublicacion, y el tamaño no pasa de 50.
     */
    private Pageable sanear(Pageable p) {
        var permitidos = Set.of("id", "titulo", "precio", "stock", "anioPublicacion");
        var orden = p.getSort().stream()
                .filter(o -> permitidos.contains(o.getProperty()))
                .toList();
        return PageRequest.of(p.getPageNumber(), Math.min(p.getPageSize(), 50),
                orden.isEmpty() ? Sort.by("titulo") : Sort.by(orden).and(Sort.by("id")));
    }
}
