package com.store.infrastructure.adapters.persistence.entity;

import com.store.domain.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name="sales", indexes={@Index(name="idx_sales_date", columnList="date"), @Index(name="idx_sales_client_id", columnList="clientId")})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true) private String numeroFacture;
    private LocalDateTime date; private BigDecimal total;
    @Enumerated(EnumType.STRING) private PaymentMode modePaiement;
    private Long clientId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) @JoinColumn(name="sale_id")
    private List<SaleLineEntity> lignes;
    @Version private Long version;
}
