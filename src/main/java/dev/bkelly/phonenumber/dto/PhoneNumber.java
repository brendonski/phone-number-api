package dev.bkelly.phonenumber.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PhoneNumber {
    
    private final long id;
    private final String number;
    @JsonIgnore
    private final Customer customer;

    public PhoneNumber(long id, String number, Customer customer) {
        this.id = id;
        this.number = number;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }

}
