package org.example.biblioteca.autores.mappers;

import org.example.biblioteca.autores.dto.AutorResponse;
import org.example.biblioteca.autores.models.Autor;
import org.springframework.stereotype.Component;

/** YA ESTA HECHO. */
@Component
public class AutorMapper {

    public AutorResponse toResponse(Autor a, Long numeroDeLibros) {
        return new AutorResponse(a.getId(), a.getNombre(), a.getNacionalidad(), numeroDeLibros);
    }
}
