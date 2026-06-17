package com.coddingSuttle.razorpay.payment.entity;

import com.coddingSuttle.razorpay.common.entity.Money;
import com.coddingSuttle.razorpay.common.enums.Orderstatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.sql.ast.tree.expression.JsonTableColumnDefinition;
import org.hibernate.type.SqlTypes;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "order_record")
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //no FK - cross service boundary
    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Orderstatus orderStatus= Orderstatus.CREATED;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String,Object> notes;

    @Column(nullable = false)
    private LocalDateTime expireAt;



}
