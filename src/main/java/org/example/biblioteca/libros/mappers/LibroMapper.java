package org.example.biblioteca.libros.mappers;

import org.example.biblioteca.autores.models.Autor;
import org.example.biblioteca.libros.dto.LibroRequest;
import org.example.biblioteca.libros.dto.LibroResponse;
import org.example.biblioteca.libros.models.Libro;
import org.springframework.stereotype.Component;

/**
 * YA ESTA HECHO. No lo toques, pero LEELO: el autor tiene que llegar
 * ya buscado (como entidad) cuando llames a toEntity o a actualizar.
 */
@Component
public class LibroMapper {

    /** Entidad -> DTO. Toca getAutor(): llamalo DENTRO de la transaccion. */
    public LibroResponse toResponse(Libro l) {
        return new LibroResponse(
                l.getId(), l.getTitulo(), l.getIsbn(), l.getPrecio(),
                l.getStock(), l.getAnioPublicacion(), l.getAutor().getNombre());
    }

    /** POST: un libro nuevo. */
    public Libro toEntity(LibroRequest r, Autor autor) {
        Libro libro = new Libro();
        actualizar(libro, r, autor);
        return libro;
    }

    /** PUT: copia TODOS los campos del request al libro. */
    public void actualizar(Libro libro, LibroRequest r, Autor autor) {
        libro.setTitulo(r.titulo().trim());
        libro.setIsbn(r.isbn().trim());
        libro.setPrecio(r.precio());
        libro.setStock(r.stock());
        libro.setAnioPublicacion(r.anioPublicacion());
        libro.setAutor(autor);
    }
}
