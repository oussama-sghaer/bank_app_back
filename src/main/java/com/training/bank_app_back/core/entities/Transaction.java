package com.training.bank_app_back.core.entities;

import com.training.bank_app_back.core.entities.enums.TransactionStatus;
import com.training.bank_app_back.core.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private TransactionType transactionType;
    private String description;
    private BigDecimal amount;
    private BigDecimal balanceAfterTransaction;
    private String referenceNumber;
    private String counterPartyAccountNumber;
    private TransactionStatus transactionStatus;
    @CreatedDate
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
    }
