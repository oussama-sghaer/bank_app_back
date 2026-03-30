package com.training.bank_app_back.core.repositories;

import com.training.bank_app_back.core.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
