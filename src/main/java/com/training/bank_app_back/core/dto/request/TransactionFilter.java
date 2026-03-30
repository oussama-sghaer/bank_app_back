package com.training.bank_app_back.core.dto.request;

import lombok.Data;

import java.time.Instant;

@Data
public class TransactionFilter {
    public Long accountId;
    public Instant startDate;
    public Instant endDate;
    public TransactionFilter(Long accountId, Instant startDate, Instant endDate){
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public TransactionFilter(Long accountId, Instant startDate){
        this.accountId = accountId;
        this.startDate = startDate;
    }
}
