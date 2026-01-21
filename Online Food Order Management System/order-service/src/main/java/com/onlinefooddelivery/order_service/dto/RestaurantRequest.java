package com.onlinefooddelivery.order_service.dto;

import lombok.Data;

@Data
public class RestaurntRequest {
    private Long orderId;
    private Long userId;
    private Long restaurantId;
}
