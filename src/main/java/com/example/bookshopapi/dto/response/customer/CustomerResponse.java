package com.example.bookshopapi.dto.response.customer;

import com.example.bookshopapi.entity.Customer;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private String accessToken;
    private Customer customer;
    private String expires_in;
}
