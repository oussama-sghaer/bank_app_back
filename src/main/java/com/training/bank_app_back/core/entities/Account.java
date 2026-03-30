package com.training.bank_app_back.core.entities;

import com.training.bank_app_back.core.entities.enums.AccountStatus;
import com.training.bank_app_back.core.entities.enums.AccountType;
import com.training.bank_app_back.core.entities.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private BigDecimal balance;
    private AccountType accountType;
    private String accountNumber;
    private Currency currency;
    private AccountStatus status;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
