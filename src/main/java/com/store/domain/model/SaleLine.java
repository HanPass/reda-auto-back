package com.store.domain.model;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SaleLine {
    private Long id;
    private Long produitId;
    private Integer quantite;
    private BigDecimal prixUnitaire;
}
