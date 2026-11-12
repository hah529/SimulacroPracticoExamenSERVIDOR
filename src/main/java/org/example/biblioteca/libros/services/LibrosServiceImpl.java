package org.example.biblioteca.libros.services;

import org.example.biblioteca.autores.repositories.AutoresRepository;
import org.example.biblioteca.libros.dto.LibroRequest;
import org.example.biblioteca.libros.dto.LibroResponse;
import org.example.biblioteca.libros.mappers.LibroMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * TAREA 5 · Sustituye cada throw por la implementacion.
 *   5.0 · Inyecta tambien el LibrosRepository por el constructor.
 * Si un metodo no te sale, DEJA EL THROW y sigue: el proyecto tiene que compilar.
 */
@Service
public class LibrosServiceImpl implements LibrosService {

    private final AutoresRepository autoresRepository;
    private final LibroMapper mapper;

    public LibrosServiceImpl(AutoresRepository autoresRepository,
                             LibroMapper mapper) {
        this.autoresRepository = autoresRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<LibroResponse> findAll(Optional<String> titulo,
                                       Optional<String> autor,
                                       Optional<BigDecimal> precioMax,
                                       Pageable pageable) {
        throw new UnsupportedOperationException("TODO 5.b");
    }

    @Override
    public LibroResponse findById(Long id) {
        throw new UnsupportedOperationException("TODO 5.a");
    }

    @Override
    public LibroResponse save(LibroRequest request) {
        throw new UnsupportedOperationException("TODO 5.a");
    }

    @Override
    public LibroResponse update(Long id, LibroRequest request) {
        throw new UnsupportedOperationException("TODO 5.a");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("TODO 5.a");
    }

    @Override
    public LibroResponse ajustarStock(Long id, int cantidad) {
        throw new UnsupportedOperationException("TODO 5.c");
    }
}
