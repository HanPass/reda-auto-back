package com.store.infrastructure.adapters.persistence.entity;

import com.store.domain.enums.CashRegisterStatus;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name="cash_registers", uniqueConstraints=@UniqueConstraint(name="uk_cash_register_date_open", columnNames={"date","statut"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CashRegisterEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private LocalDate date; private BigDecimal montantInitial; private BigDecimal totalEntrees; private BigDecimal totalSorties;
    private BigDecimal soldeTheorique; private BigDecimal soldeReel;
    @Enumerated(EnumType.STRING) private CashRegisterStatus statut;
    @Version private Long version;
}
