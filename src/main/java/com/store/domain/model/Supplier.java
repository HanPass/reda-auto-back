package com.store.domain.model;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Supplier {
    private Long id;
    private String nom;
    private String telephone;
    private String email;
    private String adresse;
    private Long version;
}
