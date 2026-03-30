package com.training.bank_app_back.core.services.v1;

import com.training.bank_app_back.core.dto.request.TransactionFilter;
import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.entities.Transaction;
import com.training.bank_app_back.core.repositories.AccountRepo;
import com.training.bank_app_back.core.repositories.TransactionRepo;
import com.training.bank_app_back.core.services.v1.interfaces.AccountService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    public AccountServiceImp(AccountRepo accountRepo ,TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepo.findById(id).orElse(null);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Transaction> getAccountTransactions(Long accountId) {
        return transactionRepo.findByAccountId(accountId);
    }

    @Override
    public List<Transaction> getAccountTransactionsByDate(TransactionFilter transactionFilter) {
        if(transactionFilter.getEndDate()!=null)
            return transactionRepo.findByAccountIdAndCreatedAtBetween(transactionFilter.getAccountId(),transactionFilter.getStartDate(),transactionFilter.getEndDate());
        return transactionRepo.findByAccountIdAndCreatedAtAfter(transactionFilter.getAccountId(),transactionFilter.getStartDate());
    }
}
