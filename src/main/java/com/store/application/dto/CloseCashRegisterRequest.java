package com.store.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record CloseCashRegisterRequest(@NotNull @PositiveOrZero BigDecimal soldeReel) {}
