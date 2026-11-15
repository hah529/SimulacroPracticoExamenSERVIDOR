package org.example.biblioteca.libros.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record StockRequest(

        @NotNull(message = "Cantidad stock obligatoria") @Min(value = -50, message = "Cantidad minima de stock -50")
        @Max(value = 50, message = "Cantidad maxima 50")
        Integer cantidad) {
}
