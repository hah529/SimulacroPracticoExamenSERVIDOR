package org.example.biblioteca.autores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** YA ESTA HECHA. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutorNotFoundException extends RuntimeException {
    public AutorNotFoundException(Long id) {
        super("No se ha encontrado el autor con id: " + id);
    }
}
