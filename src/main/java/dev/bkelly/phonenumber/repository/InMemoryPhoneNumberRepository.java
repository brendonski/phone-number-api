package dev.bkelly.phonenumber.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {
    
    private List<PhoneNumber> phoneNumbers = List.of(
            new PhoneNumber(1, "+61412345678", new Customer(1), false),
            new PhoneNumber(2, "+61881234567", new Customer(1), false),
            new PhoneNumber(1, "+61412222222", new Customer(2), false),
            new PhoneNumber(2, "+61883333333", new Customer(2), false),
            new PhoneNumber(1, "+61414444444", new Customer(3), false),
            new PhoneNumber(2, "+61885555555", new Customer(3), false)
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

    @Override
    public Optional<PhoneNumber> findById(long id) {
        if (id >= 1 && id <= 9) {
            return Optional.of(new PhoneNumber(id, "+6141412312" + id, new Customer(1), false));
        }
        return Optional.empty();
    }

    @Override
    public PhoneNumber activate(PhoneNumber phoneNumber) {
        phoneNumber.setActive(true);
        return phoneNumber;
    }

}
