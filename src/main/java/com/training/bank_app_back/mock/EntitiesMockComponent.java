package com.training.bank_app_back.mock;

import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.entities.enums.AccountStatus;
import com.training.bank_app_back.core.entities.enums.AccountType;
import com.training.bank_app_back.core.entities.Customer;
import com.training.bank_app_back.core.entities.enums.Currency;
import com.training.bank_app_back.core.entities.Transaction;
import com.training.bank_app_back.core.repositories.AccountRepo;
import com.training.bank_app_back.core.repositories.CustomerRepo;
import com.training.bank_app_back.core.repositories.TransactionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class EntitiesMockComponent implements CommandLineRunner {
    public final AccountRepo accountRepo;
    public final CustomerRepo customerRepo;
    public final TransactionRepo transactionRepo;
    public EntitiesMockComponent(AccountRepo accountRepo, CustomerRepo customerRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    public void run(String... args) {
        System.out.println("Application started with args: " + Arrays.toString(args));

        Customer customer = new Customer();
        customer.setFirstName("Oussama");
        customer.setLastName("Sghaier");
        customer.setEmail("oussama.sghaier@example.com");
        customer.setPassword("password123");
        customer.setPhoneNumber("+21600000000");
        customer.setAddress("123 Main Street");
        customer.setCity("Tunis");
        customer.setCountry("Tunisia");
        this.customerRepo.save(customer);
        Account account1 = new Account();
        account1.setBalance(BigDecimal.valueOf(1500.00));
        account1.setAccountType(AccountType.CURRENT);
        account1.setAccountNumber(generateAccountNumber());
        account1.setCurrency(Currency.TND);
        account1.setStatus(AccountStatus.ACTIVE);
        account1.setCustomer(customer);
        accountRepo.save(account1);
        Account account2 = new Account();
        account2.setBalance(BigDecimal.valueOf(5200.50));
        account2.setAccountType(AccountType.SAVINGS);
        account2.setAccountNumber(generateAccountNumber());
        account2.setCurrency(Currency.TND);
        account2.setStatus(AccountStatus.ACTIVE);
        account2.setCustomer(customer);
        accountRepo.save(account2);
        Account account3 = new Account();
        account3.setBalance(BigDecimal.valueOf(10000.00));
        account3.setAccountType(AccountType.FIXED_DEPOSIT);
        account3.setAccountNumber(generateAccountNumber());
        account3.setCurrency(Currency.TND);
        account3.setStatus(AccountStatus.BLOCKED);
        account3.setCustomer(customer);
        accountRepo.save(account3);
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(new BigDecimal("250"));
        transaction1.setAccount(account1);
        transaction1.setCounterPartyAccountNumber(account2.getAccountNumber());
        transaction1.setDescription("Deposit to Savings Account");
        transaction1.setReferenceNumber(generateTransactionReference());
        Transaction transaction2 = new Transaction();
        transaction2.setAmount(new BigDecimal("27.75"));
        transaction2.setCounterPartyAccountNumber(account1.getAccountNumber());
        transaction2.setDescription("Withdrawal from Current Account");
        transaction2.setReferenceNumber(generateTransactionReference());
        transaction2.setAccount(account2);
        Transaction transaction3 = new Transaction();
        transaction3.setAmount(new BigDecimal("40.7"));

        Transaction transaction4 = new Transaction();
        transaction4.setAmount(new BigDecimal("30.05"));

        Transaction transaction5 = new Transaction();
        transaction5.setAmount(new BigDecimal("90.00"));

        Transaction transaction6 = new Transaction();
        transaction6.setAmount(new BigDecimal("15.57"));
        transactionRepo.saveAll(Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6));

        System.out.println("Mock customer: " + customer);
        System.out.println("Mock accounts: " + account1 + ", " + account2 + ", " + account3);
        System.out.println("Mock transactions created: "
                + Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6));
    }
    public String generateTransactionReference() {
        return "TRX-" + System.currentTimeMillis();
    }
    public String generateAccountNumber() {
        return "GB-" + System.currentTimeMillis();
    }
}
