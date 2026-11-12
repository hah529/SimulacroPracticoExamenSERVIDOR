package org.example.biblioteca.libros.services;

import org.example.biblioteca.libros.dto.LibroRequest;
import org.example.biblioteca.libros.dto.LibroResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

/** YA ESTA HECHA: es el CONTRATO. No cambies las firmas. */
public interface LibrosService {

    /** Listado paginado con tres filtros OPCIONALES y acumulables. */
    Page<LibroResponse> findAll(Optional<String> titulo,
                                Optional<String> autor,
                                Optional<BigDecimal> precioMax,
                                Pageable pageable);

    LibroResponse findById(Long id);

    LibroResponse save(LibroRequest request);

    /** PUT: reemplaza todos los campos. */
    LibroResponse update(Long id, LibroRequest request);

    /** Borrado LOGICO. */
    void deleteById(Long id);

    /** Suma (cantidad positiva) o resta (negativa) unidades al stock. */
    LibroResponse ajustarStock(Long id, int cantidad);
}
