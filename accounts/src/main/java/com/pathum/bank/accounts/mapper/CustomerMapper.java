package com.pathum.bank.accounts.mapper;


import com.pathum.bank.accounts.dto.CustomerDTO;
import com.pathum.bank.accounts.model.Customer;

public class CustomerMapper {

    public static Customer mapCustomerDtoToCustomer(CustomerDTO customerDTO, Customer customer){
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }

    public static CustomerDTO mapCustomerToCustomerDto(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

}
