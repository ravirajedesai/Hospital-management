package com.biscuitShop.Biscuit_order._service.dto;

import lombok.Data;

@Data
public class BiscuitResponse {

    private Long biscuitId;
    private String biscuitName;
    private Long stock;
}
