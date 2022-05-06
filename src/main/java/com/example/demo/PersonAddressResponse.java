package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class PersonAddressResponse {
    private String personName;
    private Long personId;
    private Long addressId;
    private String addressName;
}
