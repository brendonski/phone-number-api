package dev.bkelly.phonenumber.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;
import dev.bkelly.phonenumber.repository.PhoneNumberRepository;

@RestController
public class PhoneNumberController {
    
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberController(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @GetMapping("/phone-numbers")
    public ResponseEntity<List<PhoneNumber>> phoneNumbers() {
        return ResponseEntity.ok().body(phoneNumberRepository.findAll());
    }

}
