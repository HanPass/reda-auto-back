package com.store.application.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record SaleLineRequest(@NotNull Long produitId, @NotNull @Positive Integer quantite,
                              @NotNull @PositiveOrZero BigDecimal prixUnitaire) {}
