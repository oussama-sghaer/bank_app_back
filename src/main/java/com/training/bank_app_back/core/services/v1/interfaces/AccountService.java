package com.training.bank_app_back.core.services.v1.interfaces;

import com.training.bank_app_back.core.dto.request.TransactionFilter;
import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.entities.Transaction;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAllAccounts();
    public Account getAccountById(Long id);
    public Account saveAccount(Account account);
    public Account updateAccount(Account account);
    public List<Transaction> getAccountTransactions(Long accountId);
    public List<Transaction> getAccountTransactionsByDate(TransactionFilter transactionFilter);

}
