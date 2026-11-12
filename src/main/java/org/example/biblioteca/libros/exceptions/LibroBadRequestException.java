package org.example.biblioteca.libros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** YA ESTA HECHA. 400: los datos no sirven (el autor no existe). */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LibroBadRequestException extends RuntimeException {
    public LibroBadRequestException(String mensaje) { super(mensaje); }
}
