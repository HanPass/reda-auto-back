package com.store.infrastructure.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name="products", indexes = @Index(name="idx_product_reference", columnList = "reference"), uniqueConstraints=@UniqueConstraint(name="uk_product_reference",columnNames="reference"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String reference;
    private String nom; private String categorie; private String marque;
    private BigDecimal prixAchat; private BigDecimal prixVente;
    private Integer quantiteStock; private Integer seuilAlerte; private String emplacement;
    private Long fournisseurId;
    @Version private Long version;
}
