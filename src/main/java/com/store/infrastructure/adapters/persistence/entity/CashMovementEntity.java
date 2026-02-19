package com.store.infrastructure.adapters.persistence.entity;

import com.store.domain.enums.CashMovementType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="cash_movements") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CashMovementEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long caisseId;
    @Enumerated(EnumType.STRING) private CashMovementType type;
    private BigDecimal montant; private String description; private LocalDateTime date;
}
