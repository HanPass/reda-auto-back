package com.store.domain.model;

import com.store.domain.enums.ClientStatus;
import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private String telephone;
    private String adresse;
    private BigDecimal plafondCredit;
    private BigDecimal montantCreditActuel;
    private ClientStatus statut;
    private Long version;
}
