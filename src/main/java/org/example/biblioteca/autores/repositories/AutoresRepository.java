package org.example.biblioteca.autores.repositories;

import org.example.biblioteca.autores.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/** YA ESTA HECHO. */
public interface AutoresRepository extends JpaRepository<Autor, Long> {
}
