package com.ecommerce.ecommercebackend.dto;

import com.ecommerce.ecommercebackend.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderDTO {
    private OrderStatus status;
}