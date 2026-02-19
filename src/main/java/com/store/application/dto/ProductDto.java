package com.store.application.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductDto(Long id, @NotBlank String reference, @NotBlank String nom, String categorie, String marque,
                         @NotNull @PositiveOrZero BigDecimal prixAchat, @NotNull @PositiveOrZero BigDecimal prixVente,
                         @NotNull @PositiveOrZero Integer quantiteStock, @NotNull @PositiveOrZero Integer seuilAlerte,
                         String emplacement, Long fournisseurId) {}
