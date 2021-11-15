package dev.bkelly.phonenumber.controller;

import dev.bkelly.phonenumber.dto.Customer;
import dev.bkelly.phonenumber.dto.PhoneNumber;
import dev.bkelly.phonenumber.repository.CustomerRepository;
import dev.bkelly.phonenumber.repository.PhoneNumberRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PhoneNumberController.class)
public class PhoneNumberControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneNumberRepository phoneNumberRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void getPhoneNumbers() throws Exception {
        
        var phoneNumbers = List.of(
            new PhoneNumber(1, "12345", new Customer(1), false),
            new PhoneNumber(2, "54432", new Customer(1), false)
        );

        doReturn(phoneNumbers).when(phoneNumberRepository).findAll();

        mockMvc.perform(get("/phone-numbers"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$.[0].number", is("12345")));
    }

    @Test
    void getPhoneNumbersByCustomer() throws Exception {
        
        var validCustomer = Optional.of(new Customer(1));

        var phoneNumbers = List.of(
            new PhoneNumber(1, "12345", new Customer(1), false),
            new PhoneNumber(2, "54432", new Customer(1), false)
        );

        doReturn(validCustomer).when(customerRepository).findById(1L);
        doReturn(phoneNumbers).when(phoneNumberRepository).findByCustomer(validCustomer.get());

        mockMvc.perform(get("/customers/1/phone-numbers"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$.[0].number", is("12345")));
    }

    @Test
    void getPhoneNumbersByInvalidCustomer() throws Exception {
        
        var invalidCustomer = Optional.empty();

        doReturn(invalidCustomer).when(customerRepository).findById(11L);

        mockMvc.perform(get("/customers/11/phone-numbers"))
            .andExpect(status().isNotFound());
    }

    @Test
    void activatePhoneNumber() throws Exception {
        
        var validPhoneNumber = Optional.of(new PhoneNumber(1, "+61414345671", new Customer(1), false));

        doReturn(validPhoneNumber).when(phoneNumberRepository).findById(1L);

        mockMvc.perform(put("/phone-numbers/1/activate"))
            .andExpect(status().isOk());
    }

    @Test
    void activateInvalidPhoneNumber() throws Exception {
        
        var invalidPhoneNumber = Optional.empty();

        doReturn(invalidPhoneNumber).when(phoneNumberRepository).findById(11L);

        mockMvc.perform(put("/phone-numbers/11/activate"))
            .andExpect(status().isNotFound());
    }

}
