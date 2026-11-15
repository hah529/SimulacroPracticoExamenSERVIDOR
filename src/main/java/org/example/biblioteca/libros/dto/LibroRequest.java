package org.example.biblioteca.libros.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * TAREA 3.a · Lo que ENTRA en el POST y en el PUT.
 * Los campos ya estan (el mapper los usa). Añade las validaciones
 * de la tabla del enunciado, con mensajes propios.
 */
public record LibroRequest(

        @NotBlank(message = "Titulo obligatorio") @Size(min = 1,max = 200, message = "De 1 a 200 caracteres")
        String titulo,
        @NotBlank (message = "ISBN obligatorio") @Pattern(regexp = "97[89]-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d", message = "Formato isbn no valido")
        String isbn,
        @NotNull(message = "Precio Obligatorio") @Positive(message = "Precio debe ser mayor que 0.00")
        BigDecimal precio,
        @NotNull(message = "Stock obligatorio") @PositiveOrZero(message = "Stock debe ser positivo o cero")
        Integer stock,
        @NotNull(message = "Anio obligatorio") @Min(value = 1450,message = "Anio minimo 1450") @Max(value = 2100, message = "Anio maximo 2100")
        Integer anioPublicacion,
        @NotNull(message = "autorId obligatorio")
        Long autorId
) {}
