package com.store.infrastructure.adapters.persistence.entity;

import com.store.domain.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name="clients") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ClientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String nom; private String telephone; private String adresse;
    private BigDecimal plafondCredit; private BigDecimal montantCreditActuel;
    @Enumerated(EnumType.STRING) private ClientStatus statut;
    @Version private Long version;
}
