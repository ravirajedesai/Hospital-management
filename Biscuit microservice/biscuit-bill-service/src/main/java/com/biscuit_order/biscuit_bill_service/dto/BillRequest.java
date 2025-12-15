package com.biscuit_order.biscuit_bill_service.dto;

import lombok.Data;

@Data
public class BillRequest {
    private Long orderId;
    private Long biscuitId;
    private String customerName;
    private Long quantity;
    private Long rate;
}
