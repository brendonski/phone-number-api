package dev.bkelly.phonenumber.repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {
    
    private List<PhoneNumber> phoneNumbers = List.of(
            new PhoneNumber(1, "+61412345678", new Customer(1)),
            new PhoneNumber(2, "+61881234567", new Customer(1)),
            new PhoneNumber(1, "+61412222222", new Customer(2)),
            new PhoneNumber(2, "+61883333333", new Customer(2)),
            new PhoneNumber(1, "+61414444444", new Customer(3)),
            new PhoneNumber(2, "+61885555555", new Customer(3))
        );

    @Override
    public List<PhoneNumber> findAll() {
        return phoneNumbers;
    }

    @Override
    public List<PhoneNumber> findByCustomer(Customer c) {
        return phoneNumbers.stream()
            .filter(phoneNumber -> phoneNumber.getCustomer().equals(c))
            .collect(Collectors.toList());
    }

}
