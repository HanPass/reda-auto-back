package com.store.application.dto;

import com.store.domain.enums.ClientStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ClientDto(Long id, @NotBlank String nom, String telephone, String adresse,
                        @NotNull @PositiveOrZero BigDecimal plafondCredit,
                        @NotNull @PositiveOrZero BigDecimal montantCreditActuel,
                        @NotNull ClientStatus statut) {}
