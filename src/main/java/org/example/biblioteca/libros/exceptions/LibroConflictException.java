package org.example.biblioteca.libros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** YA ESTA HECHA. 409: choca con otro libro (ISBN repetido). */
@ResponseStatus(HttpStatus.CONFLICT)
public class LibroConflictException extends RuntimeException {
    public LibroConflictException(String mensaje) { super(mensaje); }
}
