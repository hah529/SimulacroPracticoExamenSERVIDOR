package org.example.biblioteca.autores.services;

import org.example.biblioteca.autores.dto.AutorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** YA ESTA HECHO. */
public interface AutoresService {
    Page<AutorResponse> findAll(Pageable pageable);
    AutorResponse findById(Long id);
}
