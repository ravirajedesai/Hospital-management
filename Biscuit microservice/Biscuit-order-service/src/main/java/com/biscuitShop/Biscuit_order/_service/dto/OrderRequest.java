package com.biscuitShop.Biscuit_order._service.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private String customerName;
    private Long quantity;
    private String biscuitName;
}
