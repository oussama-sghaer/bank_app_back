package com.training.bank_app_back.core.controllers.v1;


import com.training.bank_app_back.core.entities.Account;
import com.training.bank_app_back.core.services.v1.interfaces.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/v1/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
