package com.store.infrastructure.adapters.persistence.entity;

import com.store.domain.enums.CreditTransactionType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="credit_transactions", indexes = @Index(name="idx_credit_client_id", columnList="clientId"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreditTransactionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long clientId; private BigDecimal montant;
    @Enumerated(EnumType.STRING) private CreditTransactionType type;
    private LocalDateTime date;
    @Version private Long version;
}
