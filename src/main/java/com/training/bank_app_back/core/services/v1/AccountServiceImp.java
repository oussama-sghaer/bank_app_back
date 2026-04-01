package com.training.bank_app_back.core.services.v1;

import com.training.bank_app_back.core.mapper.AccountMapper;
import com.training.bank_app_back.core.dto.request.TransactionFilter;
import com.training.bank_app_back.core.dto.AccountDto;
import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.entities.Transaction;
import com.training.bank_app_back.core.repositories.AccountRepo;
import com.training.bank_app_back.core.repositories.TransactionRepo;
import com.training.bank_app_back.core.services.v1.interfaces.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    private final AccountMapper accountMapper ;
    public AccountServiceImp(AccountRepo accountRepo ,TransactionRepo transactionRepo,AccountMapper accountMapper) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
        this.accountMapper = accountMapper;
    }
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepo.findAll();

        return accountMapper.toDtoList(accounts);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account==null)
            return null;
        return accountMapper.toDto(account);
    }

    @Override
    public AccountDto saveAccount(Account account) {
        Account accountSaved =accountRepo.save(account);
        return accountMapper.toDto(accountSaved);
    }

    @Override
    public AccountDto updateAccount(Account account) {
        Account accountSaved =accountRepo.save(account);
        return accountMapper.toDto(accountSaved);
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
