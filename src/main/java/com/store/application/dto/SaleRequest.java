package com.store.application.dto;

import com.store.domain.enums.PaymentMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public record SaleRequest(@NotNull PaymentMode modePaiement, Long clientId, @NotEmpty @Valid List<SaleLineRequest> lignes) {}
