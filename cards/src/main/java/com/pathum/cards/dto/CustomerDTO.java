package com.pathum.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
