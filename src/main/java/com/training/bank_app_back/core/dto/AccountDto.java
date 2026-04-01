package com.training.bank_app_back.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountNumber;
    private String accountType;
    private String currency;
    private String status;
    private String balance;
}
