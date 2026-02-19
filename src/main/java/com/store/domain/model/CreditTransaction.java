package com.store.domain.model;

import com.store.domain.enums.CreditTransactionType;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CreditTransaction {
    private Long id;
    private Long clientId;
    private BigDecimal montant;
    private CreditTransactionType type;
    private LocalDateTime date;
    private Long version;
}
