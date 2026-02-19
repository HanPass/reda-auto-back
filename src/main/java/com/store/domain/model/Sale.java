package com.store.domain.model;

import com.store.domain.enums.PaymentMode;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Sale {
    private Long id;
    private String numeroFacture;
    private LocalDateTime date;
    private BigDecimal total;
    private PaymentMode modePaiement;
    private Long clientId;
    private List<SaleLine> lignes;
    private Long version;
}
