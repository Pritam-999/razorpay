package com.coddingSuttle.razorpay.payment.entity;

import com.coddingSuttle.razorpay.common.enums.PaymentActor;
import com.coddingSuttle.razorpay.common.enums.PaymentEvent;
import com.coddingSuttle.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_log")
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status",length = 30, nullable = false)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", length = 30, nullable = false)
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", length = 30, nullable = false)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "actor", length = 30, nullable = false)
    private PaymentActor actor;

    @Column(name = "occurred_at", nullable = false)
    private String occurredAt;


}
