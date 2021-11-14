package dev.bkelly.phonenumber.repository;

import java.util.Optional;
import dev.bkelly.phonenumber.dto.Customer;

public interface CustomerRepository {
    
    public Optional<Customer> findById(long id);

}
