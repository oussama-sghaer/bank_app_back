package com.training.bank_app_back.core.services.v1.interfaces;

import com.training.bank_app_back.core.dto.request.TransactionFilter;
import com.training.bank_app_back.core.dto.AccountDto;
import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.entities.Transaction;

import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccounts();
    public AccountDto getAccountById(Long id);
    public AccountDto saveAccount(Account account);
    public AccountDto updateAccount(Account account);
    public List<Transaction> getAccountTransactions(Long accountId);
    public List<Transaction> getAccountTransactionsByDate(TransactionFilter transactionFilter);

}
