package com.starwars.planetas.domain.planeta;

import jakarta.validation.constraints.NotBlank;

public record PlanetaPostDTO(
    @NotBlank
    String nome, 
    @NotBlank
    String clima, 
    @NotBlank
    String terreno
    ) {
}
