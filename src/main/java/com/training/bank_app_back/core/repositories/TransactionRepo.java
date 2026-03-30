package com.training.bank_app_back.core.repositories;

import com.training.bank_app_back.core.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndCreatedAtBetween(Long accountId, Instant startDate, Instant endDate);
    List<Transaction> findByAccountIdAndCreatedAtAfter(Long accountId, Instant startDate);
}
