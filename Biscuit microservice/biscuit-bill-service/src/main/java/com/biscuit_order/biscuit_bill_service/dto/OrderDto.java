package com.biscuit_order.biscuit_bill_service.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long orderId;
    private Long biscuitId;
    private String customerName;
    private Long quantity;
}
