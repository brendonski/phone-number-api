package dev.bkelly.phonenumber.repository;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;
import java.util.List;
import java.util.Optional;

public interface PhoneNumberRepository {
    
    public List<PhoneNumber> findAll();

    public List<PhoneNumber> findByCustomer(Customer c);

    public Optional<PhoneNumber> findById(long id);

    public PhoneNumber activate(PhoneNumber phoneNumber);
}
