package org.example.biblioteca.libros.dto;

import java.math.BigDecimal;

/** YA ESTA HECHO. Lo que SALE: lleva el NOMBRE del autor y no expone "deleted". */
public record LibroResponse(
        Long id,
        String titulo,
        String isbn,
        BigDecimal precio,
        Integer stock,
        Integer anioPublicacion,
        String autor
) {}
