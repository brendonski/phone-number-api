package dev.bkelly.phonenumber.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PhoneNumber {
    
    private final long id;
    private final String number;
    private final Customer customer;
    private boolean active;

    public PhoneNumber(long id, String number, Customer customer, boolean active) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
