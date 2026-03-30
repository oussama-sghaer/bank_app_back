package com.training.bank_app_back.core.repositories;

import com.training.bank_app_back.core.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}
