package com.store.infrastructure.adapters.rest;

import com.store.application.dto.CloseCashRegisterRequest;
import com.store.application.dto.OpenCashRegisterRequest;
import com.store.application.service.CashRegisterService;
import com.store.domain.model.CashRegister;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/cash-registers") @RequiredArgsConstructor
public class CashRegisterController {
    private final CashRegisterService service;
    @PostMapping("/open") public CashRegister open(@Valid @RequestBody OpenCashRegisterRequest request){ return service.open(request.montantInitial()); }
    @PostMapping("/{id}/close") public CashRegister close(@PathVariable Long id, @Valid @RequestBody CloseCashRegisterRequest request){ return service.close(id, request.soldeReel()); }
}
