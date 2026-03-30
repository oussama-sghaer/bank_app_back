package com.training.bank_app_back.core.services.v1.interfaces;

import com.training.bank_app_back.core.entities.Customer;

public interface CustomerService {
    public Customer getCustomerById(Long id);
    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);

}
