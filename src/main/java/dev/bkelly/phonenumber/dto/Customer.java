package dev.bkelly.phonenumber.dto;

import java.util.Objects;

public class Customer {

    private final long id;

    public Customer(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer cust = (Customer) o;
        return id == cust.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
