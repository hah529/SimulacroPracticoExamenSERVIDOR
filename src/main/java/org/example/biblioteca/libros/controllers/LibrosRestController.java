package org.example.biblioteca.libros.controllers;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.biblioteca.libros.dto.LibroRequest;
import org.example.biblioteca.libros.dto.LibroResponse;
import org.example.biblioteca.libros.models.Libro;
import org.example.biblioteca.libros.services.LibrosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * TAREA 6 · Los seis endpoints de la tabla del enunciado.
 * Fijate en AutoresRestController: es el mismo patron.
 */
@RestController
@RequestMapping("${api.path}/${api.version}/libros")
public class LibrosRestController {

    private final LibrosService servicio;

    public LibrosRestController(LibrosService servicio) {this.servicio = servicio; }

    @GetMapping
    public ResponseEntity<Page<LibroResponse>> findAll (
            @RequestParam Optional<String> titulo,
            @RequestParam Optional<String> autor,
            @RequestParam Optional <BigDecimal> precioMAX,
            @PageableDefault(size = 10, sort = "id") Pageable pageable ){

        return  ResponseEntity.ok(servicio.findAll(titulo,autor,precioMAX, sanear(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> findById (@PathVariable Long id){
        return ResponseEntity.ok(servicio.findById(id));
    }

    @PostMapping
    public ResponseEntity<LibroResponse> save (@Valid @RequestBody LibroRequest libroAGuardar){

        var creado = servicio.save(libroAGuardar);

        return ResponseEntity.created(URI.create("api/v1/libros"+creado.id())).body(creado);
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
