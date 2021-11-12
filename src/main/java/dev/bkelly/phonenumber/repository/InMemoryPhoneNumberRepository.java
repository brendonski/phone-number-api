package dev.bkelly.phonenumber.repository;

import java.util.Collections;
import java.util.List;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {
    
    private List<PhoneNumber> phoneNumbers = List.of(
            new PhoneNumber(1, "12345", new Customer(1)),
            new PhoneNumber(2, "54432", new Customer(1))
        );

    @Override
    public List<PhoneNumber> findAll() {
        return Collections.unmodifiableList(phoneNumbers);
    }
}
