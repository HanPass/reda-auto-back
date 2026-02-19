package com.store.domain.model;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Product {
    private Long id;
    private String reference;
    private String nom;
    private String categorie;
    private String marque;
    private BigDecimal prixAchat;
    private BigDecimal prixVente;
    private Integer quantiteStock;
    private Integer seuilAlerte;
    private String emplacement;
    private Long fournisseurId;
    private Long version;
}
