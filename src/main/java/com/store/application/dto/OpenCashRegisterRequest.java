package com.store.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record OpenCashRegisterRequest(@NotNull @PositiveOrZero BigDecimal montantInitial) {}
