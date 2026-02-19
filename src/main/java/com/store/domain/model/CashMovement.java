package com.store.domain.model;

import com.store.domain.enums.CashMovementType;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CashMovement {
    private Long id;
    private Long caisseId;
    private CashMovementType type;
    private BigDecimal montant;
    private String description;
    private LocalDateTime date;
}
