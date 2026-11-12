package org.example.biblioteca.libros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** YA ESTA HECHA. 404: el libro no existe o esta borrado. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(Long id) {
        super("No se ha encontrado el libro con id: " + id);
    }
}
