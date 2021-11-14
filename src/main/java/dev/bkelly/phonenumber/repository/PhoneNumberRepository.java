package dev.bkelly.phonenumber.repository;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;
import java.util.List;

public interface PhoneNumberRepository {
    
    public List<PhoneNumber> findAll();

    public List<PhoneNumber> findByCustomer(Customer c);

}
