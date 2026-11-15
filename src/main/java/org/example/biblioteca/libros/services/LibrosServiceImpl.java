package org.example.biblioteca.libros.services;

import org.example.biblioteca.autores.repositories.AutoresRepository;
import org.example.biblioteca.libros.dto.LibroRequest;
import org.example.biblioteca.libros.dto.LibroResponse;
import org.example.biblioteca.libros.exceptions.LibroBadRequestException;
import org.example.biblioteca.libros.exceptions.LibroConflictException;
import org.example.biblioteca.libros.exceptions.LibroNotFoundException;
import org.example.biblioteca.libros.exceptions.LibroSinStockException;
import org.example.biblioteca.libros.mappers.LibroMapper;
import org.example.biblioteca.libros.models.Libro;
import org.example.biblioteca.libros.repositories.LibrosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
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
    private final LibrosRepository librosRepository;

    public LibrosServiceImpl(AutoresRepository autoresRepository,
                             LibroMapper mapper, LibrosRepository librosRepository) {
        this.autoresRepository = autoresRepository;
        this.mapper = mapper;
        this.librosRepository = librosRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LibroResponse> findAll(Optional<String> titulo,
                                       Optional<String> autor,
                                       Optional<BigDecimal> precioMax,
                                       Pageable pageable) {

        Specification<Libro> spec =  ((root, query, cb) -> cb.isFalse(root.get("deleted")));

        if(titulo.isPresent()){
            spec= spec.and(
                    (root, query, cb) ->
                    cb.like(cb.lower(root.get("titulo")),"%" + titulo.get().toLowerCase()+ "%")
            );
        }
        if(autor.isPresent()){
            spec = spec.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("autor").get("nombre")), "%"+
                                    autor.get().toLowerCase()+ "%")
            );
        }
        if(precioMax.isPresent()){
            spec= spec.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.lessThanOrEqualTo(root.get("precio"), precioMax.get())
            );
        }

        return librosRepository.findAll(spec,pageable).map(mapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public LibroResponse findById(Long id) {

        return librosRepository.findByIdAndDeletedFalse(id).map(mapper::toResponse)
                .orElseThrow(() -> new LibroNotFoundException(id));

    }

    @Override
    @Transactional
    public LibroResponse save(LibroRequest request) {

        if(librosRepository.existsLibroByIsbn(request.isbn())){
            throw new LibroConflictException("Ya existe un libro con el ISBN: "+request.isbn());
        }

        var autor = autoresRepository.findById(request.autorId())
                .orElseThrow(() -> new LibroBadRequestException("Autor no existe"));

        var libro = mapper.toEntity(request,autor);
        var libroguardado = librosRepository.save(libro);

        return mapper.toResponse(libroguardado);
    }

    @Transactional
    @Override
    public LibroResponse update(Long id, LibroRequest request) {

        var libro= librosRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new LibroNotFoundException(id)
        );

        if(!libro.getIsbn().equalsIgnoreCase(request.isbn())){
            if(librosRepository.existsLibroByIsbn(request.isbn())){
                throw new LibroConflictException("Ya existe un libro con el ISBN: "+request.isbn());
            }
        }

        var autor =autoresRepository.findById(request.autorId()).orElseThrow(
                () -> new LibroBadRequestException("EL autor con id: "+request.autorId()+ " no existe")
        );

        mapper.actualizar(libro,request,autor);
        var libroActualizado = librosRepository.save(libro);

        return mapper.toResponse(libroActualizado);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

        var libro = librosRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new LibroNotFoundException(id));
        libro.setDeleted(true);
        librosRepository.save(libro);

    }

    @Transactional
    @Override
    public LibroResponse ajustarStock(Long id, int cantidad) {

        var libro = librosRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new LibroNotFoundException(id));

        var nuevoStock =cantidad+libro.getStock();

        if (nuevoStock<0) throw new LibroSinStockException(libro.getTitulo(),libro.getStock(),cantidad);

        libro.setStock(cantidad);
        librosRepository.save(libro);

        return mapper.toResponse(libro);

    }
}
