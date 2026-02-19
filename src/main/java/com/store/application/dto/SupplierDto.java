package com.store.application.dto;

import jakarta.validation.constraints.NotBlank;

public record SupplierDto(Long id, @NotBlank String nom, String telephone, String email, String adresse) {}
