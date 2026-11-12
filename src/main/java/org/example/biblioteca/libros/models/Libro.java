package org.example.biblioteca.libros.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.biblioteca.autores.models.Autor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * TAREA 1 · Convierte esta clase en una ENTIDAD JPA que genere exactamente
 * la tabla "libros" de la TAREA 1 del enunciado.
 *
 * Los campos, los getters/setters (Lombok) y el constructor vacio ya estan:
 * NO cambies sus nombres ni sus tipos, porque el mapper los usa.
 * Todavia NO es una entidad: por eso el proyecto arranca sin ella.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "isbn",length = 20,nullable = false,unique = true)
    private String isbn;

    @Column(name = "precio",precision = 10,scale = 2,nullable = false)
    private BigDecimal precio;

    @Column(name = "stock",nullable = false)
    private Integer stock;

    @Column(name = "anio_publicacion",nullable = false)
    private Integer anioPublicacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)       // lado de la FK
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(nullable = false)
    private boolean deleted = false;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

}
