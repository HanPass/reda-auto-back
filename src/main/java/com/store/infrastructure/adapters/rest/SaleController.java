package com.store.infrastructure.adapters.rest;
import com.store.application.dto.SaleRequest;
import com.store.application.service.SaleService;
import com.store.domain.model.Sale;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/sales") @RequiredArgsConstructor
public class SaleController {
    private final SaleService service;
    @PostMapping public Sale create(@Valid @RequestBody SaleRequest request){ return service.create(request); }
}
