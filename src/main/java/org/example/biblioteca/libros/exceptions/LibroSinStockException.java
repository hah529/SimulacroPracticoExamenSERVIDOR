package org.example.biblioteca.libros.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)

public class LibroSinStockException extends RuntimeException {
    public LibroSinStockException(String titulo, int stock,int cantidad) {
        super("El libro '" +titulo+"' tiene " +stock+ " unidades: no se pueden retirar "+cantidad);
    }
}
