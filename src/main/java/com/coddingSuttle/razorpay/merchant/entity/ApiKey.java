package com.coddingSuttle.razorpay.merchant.entity;

import com.coddingSuttle.razorpay.common.enums.Environment;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="api_key")
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(length = 50,nullable = false)
    private String apiId;


    @Column(length = 200,nullable = false,unique = true)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 10)
    private Environment environment;

    @Column(nullable = false)
    private Boolean enabled = true;


    private java.time.LocalDateTime lastUsedAt;
    private java.time.LocalDateTime rotatedAt;
    private java.time.LocalDateTime gracePeriodExpiresAt;
}
