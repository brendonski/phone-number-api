package dev.bkelly.phonenumber.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;
import dev.bkelly.phonenumber.repository.CustomerRepository;
import dev.bkelly.phonenumber.repository.PhoneNumberRepository;

@RestController
public class PhoneNumberController {
    
    private final PhoneNumberRepository phoneNumberRepository;

    private final CustomerRepository customerRepository;

    public PhoneNumberController(
        PhoneNumberRepository phoneNumberRepository,
        CustomerRepository customerRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/phone-numbers")
    public ResponseEntity<List<PhoneNumber>> phoneNumbers() {
        return ResponseEntity.ok().body(phoneNumberRepository.findAll());
    }

    @GetMapping("/customers/{id}/phone-numbers")
    public ResponseEntity<List<PhoneNumber>> phoneNumbersByCustomer(
        @PathVariable(value = "id") Long id
    ) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("id-" + id);
        }
        return ResponseEntity.ok().body(phoneNumberRepository.findByCustomer(customer.get()));
    }

}
