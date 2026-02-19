package com.store.infrastructure.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="suppliers") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SupplierEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String nom; private String telephone; private String email; private String adresse;
    @Version private Long version;
}
