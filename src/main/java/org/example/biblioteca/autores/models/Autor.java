package org.example.biblioteca.autores.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * YA ESTA HECHA, salvo el lado inverso de la relacion (TAREA 1.e).
 * Fijate en ella para hacer Libro.
 */
@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 120)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String nacionalidad;

    // TODO 1.e · el lado INVERSO de la relacion con Libro
}
