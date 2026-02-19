package com.store.domain.model;

import com.store.domain.enums.CashRegisterStatus;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CashRegister {
    private Long id;
    private LocalDate date;
    private BigDecimal montantInitial;
    private BigDecimal totalEntrees;
    private BigDecimal totalSorties;
    private BigDecimal soldeTheorique;
    private BigDecimal soldeReel;
    private CashRegisterStatus statut;
    private Long version;
}
