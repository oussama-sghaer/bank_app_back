package com.training.bank_app_back.core.repositories;

import com.training.bank_app_back.core.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
