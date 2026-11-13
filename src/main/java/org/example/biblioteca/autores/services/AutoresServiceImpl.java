package org.example.biblioteca.autores.services;

import org.example.biblioteca.autores.dto.AutorResponse;
import org.example.biblioteca.autores.exceptions.AutorNotFoundException;
import org.example.biblioteca.autores.mappers.AutorMapper;
import org.example.biblioteca.autores.repositories.AutoresRepository;
import org.example.biblioteca.libros.models.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** HECHO, salvo la TAREA 1.f (en findById). Es el patron de tu LibrosServiceImpl. */
@Service
public class AutoresServiceImpl implements AutoresService {

    private final AutoresRepository repositorio;
    private final AutorMapper mapper;

    public AutoresServiceImpl(AutoresRepository repositorio, AutorMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    /** En el listado no se cuentan los libros: numeroDeLibros va a null. */
    @Override
    @Transactional(readOnly = true)
    public Page<AutorResponse> findAll(Pageable pageable) {
        return repositorio.findAll(pageable).map(a -> mapper.toResponse(a, null));
    }

    @Override
    @Transactional(readOnly = true)
    public AutorResponse findById(Long id) {
        var autor = repositorio.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));

        var numeroDeLibros=autor.getLibros().stream().filter(libro -> !libro.isDeleted()).count();

        // TODO 1.f · numeroDeLibros = cuantos libros NO borrados tiene el autor,
        //            contados con el lado inverso de la relacion (autor.getLibros())
        return mapper.toResponse(autor, numeroDeLibros);
    }
}
