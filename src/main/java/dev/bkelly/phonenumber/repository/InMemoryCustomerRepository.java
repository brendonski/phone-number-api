package dev.bkelly.phonenumber.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    
    @Override
    public Optional<Customer> findById(long id) {
        if (id >= 1 && id <= 10) {
            return Optional.of(new Customer(id));
        }
        return Optional.empty();
    }

}
