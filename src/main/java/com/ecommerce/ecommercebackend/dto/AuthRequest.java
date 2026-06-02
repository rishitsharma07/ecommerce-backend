package com.ecommerce.ecommercebackend.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}