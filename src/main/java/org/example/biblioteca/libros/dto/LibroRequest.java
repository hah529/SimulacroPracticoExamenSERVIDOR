package org.example.biblioteca.libros.dto;

import java.math.BigDecimal;

/**
 * TAREA 3.a · Lo que ENTRA en el POST y en el PUT.
 * Los campos ya estan (el mapper los usa). Añade las validaciones
 * de la tabla del enunciado, con mensajes propios.
 */
public record LibroRequest(
        String titulo,
        String isbn,
        BigDecimal precio,
        Integer stock,
        Integer anioPublicacion,
        Long autorId
) {}
