package com.store.infrastructure.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name="sale_lines") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleLineEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long produitId; private Integer quantite; private BigDecimal prixUnitaire;
}
