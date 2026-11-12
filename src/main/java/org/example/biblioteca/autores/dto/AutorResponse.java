package org.example.biblioteca.autores.dto;

/**
 * YA ESTA HECHO. numeroDeLibros: los libros NO borrados del autor.
 * Solo se rellena en GET /autores/{id}; en el listado va a null.
 */
public record AutorResponse(Long id, String nombre, String nacionalidad, Long numeroDeLibros) {}
