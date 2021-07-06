package com.ro.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class CustomerDTO {
private CustomerRequest customerRequest;
private  CustomerResponse customerResponse;
}
