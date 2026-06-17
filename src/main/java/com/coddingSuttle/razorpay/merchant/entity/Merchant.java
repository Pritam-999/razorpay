package com.coddingSuttle.razorpay.merchant.entity;

import com.coddingSuttle.razorpay.common.enums.BusinessType;
import com.coddingSuttle.razorpay.common.enums.MerchantStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length =20)
    private String contactNumber;

    @Column(length =50)
    @Enumerated(EnumType.STRING)

    private BusinessType businesstype;

    @Column(length =100)
    private String BusinessName;

    @Column(length =200)
    private String website;

    @Column(length = 200, nullable = false)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status =  MerchantStatus.PENDING_KYC;

    @Column(length = 20)
    private String gstId;

    @Column(length = 20)
    private String panId;

    @Column(length = 20)
    private String settelementBankAccount;

    @Column(length = 20)
    private String settelementBankName;

    @Column(length = 100)
    private String settelementBankAccountHolderName;
    


}
