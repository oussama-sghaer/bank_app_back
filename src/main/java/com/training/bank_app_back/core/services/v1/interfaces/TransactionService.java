package com.training.bank_app_back.core.services.v1.interfaces;

import com.training.bank_app_back.core.entities.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions();
    public Transaction getTransactionById(Long id);
}
